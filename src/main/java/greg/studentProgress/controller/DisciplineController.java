package greg.studentProgress.controller;

import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by GreG on 15.09.2014.
 */
@Controller
@RequestMapping(value = "/discipline")
public class DisciplineController {

    @Autowired
    private DisciplineService disciplineService;


    @RequestMapping(value = "/disciplineList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("discipline", new Student());
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


}
