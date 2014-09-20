package greg.studentProgress.controller;

import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/discipline")
@SessionAttributes("disciplineModifying")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;


    @RequestMapping(value = "/disciplineList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplineList";
    }

    @RequestMapping(value = "/handlerDisciplineList", method = RequestMethod.POST)
    public String studentProgressList(@RequestParam(value = "id", required = false) long[] id,
                                      @RequestParam String action,
                                      @ModelAttribute Discipline modifyingDiscipline,
                                      RedirectAttributes redirectAttributes) {
        if (!(id == null)) {
            if (action.equals("remove")) {
                for (long currID : id) {
                    disciplineService.remove(disciplineService.findById(currID));
                }
            } else if (action.equals("modifying")) {
                for (long currID : id) {
                    modifyingDiscipline = disciplineService.findById(currID);
                    redirectAttributes.addFlashAttribute("modifyingDiscipline", modifyingDiscipline);
                }
                return "redirect:/student/disciplineModifying";
            } else if (action.equals("creating")) {
                return "redirect:/discipline/disciplineCreating";
            }
        }
        return "redirect:/discipline/disciplineList";
    }

    @RequestMapping(value = "/disciplineCreating", method = RequestMethod.GET)
    public String disciplineCreating(ModelMap model) {
        model.addAttribute("discipline", new Discipline());
        model.addAttribute("disciplineModifying", new Discipline());
        return "disciplineCreating";
    }

    @RequestMapping(value = "/disciplineModifying", method = RequestMethod.GET)
    public String disciplineModifying(ModelMap model) {
        model.addAttribute("discipline", new Discipline());
        model.addAttribute("disciplineModifying", new Discipline());
        return "disciplineCreating";
    }

    @RequestMapping(value = "/disciplineSave", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("discipline") Discipline discipline, BindingResult result) {
        disciplineService.add(discipline);
        return "redirect:/discipline/disciplineList";
    }


 }
