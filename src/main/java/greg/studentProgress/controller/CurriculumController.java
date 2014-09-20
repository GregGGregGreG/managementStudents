package greg.studentProgress.controller;

import greg.studentProgress.dto.CurriculumDto;
import greg.studentProgress.persistence.service.CurriculumService;
import greg.studentProgress.persistence.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/curriculum")
public class CurriculumController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private TermService termService;

    private int nameTerm = 1;

    @RequestMapping(value = "/curriculumList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("curriculum", termService.findAll());
        model.addAttribute("term", new CurriculumDto());
        model.addAttribute("listDiscipline", curriculumService.findByTerm(nameTerm));
        model.addAttribute("weekTerm", termService.findByName(nameTerm));
        nameTerm = 0;
        return "curriculumList";
    }

    @RequestMapping(value = "/showDisciplineInTerm", method = RequestMethod.POST)
    public String listDiscipline(@ModelAttribute("term") CurriculumDto curriculumDto, BindingResult result) {
        nameTerm = Integer.parseInt(curriculumDto.getNameTerm());
        return "redirect:/curriculum/curriculumList";
    }


    //
//    @RequestMapping(value = "/saveDiscipline", method = RequestMethod.POST)
//    public String saveStudent(@ModelAttribute("discipline") Discipline discipline, BindingResult result) {
//        disciplineService.add(discipline);
//        return "redirect:/discipline/disciplineList";
//    }
}
