package greg.studentProgress.controller;

import greg.studentProgress.dto.DisciplineDto;
import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/disciplines")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplineList";
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.POST, params = "modifying")
    public String studentProgressList(@RequestParam(value = "id", required = false) long[] id) {
        for (long currID : id) {
            return "redirect:/disciplines/admin/creating/" + currID;
        }
        return "redirect:/discipline/";
    }

    @RequestMapping(value = "/admin/", method = RequestMethod.POST, params = "delete")
    public String studentsDelete(@RequestParam(value = "id", required = false) long[] id) {
        for (long currID : id) {
            disciplineService.remove(disciplineService.findById(currID));
        }
        return "redirect:/disciplines/";
    }

    @RequestMapping(value = "/admin/creating", method = RequestMethod.GET)
    public String disciplineCreating(ModelMap model) {
        model.addAttribute("discipline", new Discipline());
        return "disciplineCreating";
    }

    @RequestMapping(value = "/admin/creating", method = RequestMethod.POST)
    public String disciplineSave(@Valid @ModelAttribute("discipline") DisciplineDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "disciplineCreating";
        }
        Discipline discipline = new Discipline();
        String name = dto.getName();
        discipline.setName(name);
        disciplineService.add(discipline);
        return "redirect:/disciplines/";
    }

    @RequestMapping(value = "/admin/creating/{disciplineId}", method = RequestMethod.GET)
    public String disciplineModifying(ModelMap model, @PathVariable("disciplineId") Long disciplineId) {
        Discipline discipline = disciplineService.findById(disciplineId);
        model.addAttribute("discipline", discipline);
        return "disciplineCreating";
    }

    @RequestMapping(value = "/admin/creating/{disciplineId}", method = RequestMethod.POST)
    public String disciplineModifyingSave(@PathVariable("disciplineId") Long disciplineId,
                                          @Valid @ModelAttribute("discipline") DisciplineDto dto, BindingResult result) {
        if (result.hasErrors()) {
            return "disciplineCreating";
        }
        Discipline discipline = disciplineService.findById(disciplineId);
        String name = dto.getName();
        discipline.setName(name);
        disciplineService.add(discipline);
        return "redirect:/disciplines/";
    }
}
