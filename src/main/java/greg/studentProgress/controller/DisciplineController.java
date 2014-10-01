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
@RequestMapping(value = "/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;

    @RequestMapping(value = "/disciplineList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplineList";
    }

    @RequestMapping(value = "/admin/handlerDisciplineList", method = RequestMethod.POST)
    public String studentProgressList(@RequestParam(value = "id", required = false) long[] id,
                                      @RequestParam String action) {
        if (!(id == null)) {
            switch (action) {
                case "remove":
                    for (long currID : id) {
                        disciplineService.remove(disciplineService.findById(currID));
                    }
                    break;
                case "modifying":
                    for (long currID : id) {
                        return "redirect:/discipline/admin/disciplineModifying/" + currID;
                    }
            }
        }
        if (action.equals("creating")) {
            return "redirect:/discipline/admin/disciplineCreating";
        }
        return "redirect:/discipline/disciplineList";
    }

    @RequestMapping(value = "/admin/disciplineCreating", method = RequestMethod.GET)
    public String disciplineCreating(ModelMap model) {
        model.addAttribute("discipline", new Discipline());
        return "disciplineCreating";
    }

    @RequestMapping(value = "/admin/disciplineModifying/{disciplineId}", method = RequestMethod.GET)
    public String disciplineModifying(ModelMap model,
                                      @PathVariable("disciplineId") Long disciplineId) {
        Discipline modifyingDiscipline = disciplineService.findById(disciplineId);
        model.addAttribute("discipline", modifyingDiscipline);
        return "disciplineCreating";
    }

    @RequestMapping(value = "/admin/disciplineSave", method = RequestMethod.POST)
    public String disciplineSave(@Valid @ModelAttribute("discipline") DisciplineDto dto, BindingResult result)  {
        if (result.hasErrors()) {
            return "disciplineCreating";
        }
        Discipline discipline = disciplineService.findById(dto.getId());
        if (discipline == null) {
            discipline = new Discipline();
        }
        String disciplineName = dto.getName();
        discipline.setName(disciplineName);
        disciplineService.add(discipline);
        return "redirect:/discipline/disciplineList";
    }
}
