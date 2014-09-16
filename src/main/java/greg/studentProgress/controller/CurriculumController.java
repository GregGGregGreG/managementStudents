package greg.studentProgress.controller;

import greg.studentProgress.persistence.service.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;


    @RequestMapping(value = "/curriculumList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
//        model.addAttribute("curriculum", curriculumService.findByTerm());
        return "termList";
    }
//    @RequestMapping(value = "/addDiscipline", method = RequestMethod.GET)
//    public String addStudent(ModelMap model) {
//        model.addAttribute("discipline", new Discipline());
//        return "addDiscipline";
//    }
//
//    @RequestMapping(value = "/saveDiscipline", method = RequestMethod.POST)
//    public String saveStudent(@ModelAttribute("discipline") Discipline discipline, BindingResult result) {
//        disciplineService.add(discipline);
//        return "redirect:/discipline/disciplineList";
//    }
}
