package greg.studentProgress.controller;

import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/discipline")
public class DisciplineController {
    @Autowired
    private DisciplineService disciplineService;
    private Discipline modifyingDiscipline;


    @RequestMapping(value = "/disciplineList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("disciplines", disciplineService.findAll());
        return "disciplineList";
    }
    @RequestMapping(value = "/addDiscipline", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("discipline", new Discipline());
        return "addDiscipline";
    }

    @RequestMapping(value = "/saveDiscipline", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("discipline") Discipline discipline, BindingResult result) {
        disciplineService.add(discipline);
        return "redirect:/discipline/disciplineList";
    }


    @RequestMapping(value = "/disciplineAction", method = RequestMethod.POST)
    public String studentProgressList(@RequestParam(value = "id", required = false) long[] id,
                                      @RequestParam String action,
                                      RedirectAttributes redirectAttributes) {

        if (action.equals("remove")) {
            if (!(id == null)) {
                for (long currID : id) {
                    Discipline discipline = disciplineService.findById(currID);
                    disciplineService.remove(discipline);
                }
            }
        } else if (action.equals("modifying")) {
            if (!(id == null)) {
                for (long currID : id) {
                    modifyingDiscipline = (disciplineService.findById(currID));
                    redirectAttributes.addFlashAttribute("modifyingDiscipline", modifyingDiscipline);
                }
                return "redirect:/student/studentModifying";
            }
        }
        return "redirect:/discipline/disciplineList";
    }


}
