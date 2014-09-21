package greg.studentProgress.controller;

import greg.studentProgress.dto.CurriculumDto;
import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.domain.Term;
import greg.studentProgress.persistence.service.CurriculumService;
import greg.studentProgress.persistence.service.DisciplineService;
import greg.studentProgress.persistence.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@RequestMapping("/term")
public class TermController {

    @Autowired
    private CurriculumService curriculumService;

    @Autowired
    private DisciplineService disciplineService;

    @Autowired
    private TermService termService;

    @RequestMapping(value = "/termsList", method = RequestMethod.GET)
    public String termList(ModelMap model,

                           @ModelAttribute("term") CurriculumDto dto) {

        model.addAttribute("term", new CurriculumDto());
        model.addAttribute("curriculum", termService.findAll());
        if (!(dto.getNameTerm() == null)) {
            model.addAttribute("listDiscipline", curriculumService.findByTerm(Integer.parseInt(dto.getNameTerm())));
            model.addAttribute("weekTerm", termService.findByName(Integer.parseInt(dto.getNameTerm())));
        }
        return "termsList";
    }

    @RequestMapping(value = "/termsList/{termID}", method = RequestMethod.GET)
    public String termListId(ModelMap model,
                             @PathVariable("termID") int termId) {
        model.addAttribute("term", new CurriculumDto());
        model.addAttribute("curriculum", termService.findAll());
        model.addAttribute("listDiscipline", curriculumService.findByTerm(termId));
        model.addAttribute("weekTerm", termService.findByName(termId));
        return "termsList";
    }


    @RequestMapping(value = "/handlerTermsList", method = RequestMethod.POST)
    public String studentProgressList(
            @ModelAttribute("term") CurriculumDto dto,
            @RequestParam String action) {
        switch (action) {
            case "removeList":
                termService.remove(termService.findByName(Integer.parseInt(dto.getNameTerm())));
                break;
            case "modifying":
                return "redirect:/term/termModifying/" + dto.getNameTerm();
            case "creating":
                return "redirect:/term/termCreating";
        }
        return "redirect:/term/termsList/" + dto.getNameTerm();
    }

    @RequestMapping(value = "/termCreating", method = RequestMethod.GET)
    public String termCreating(ModelMap model) {
        String massage = "Для создания семестра заполните следующие данные и нажмите кнопку  \"Создать\" ";
        String nameButton = "Создать";
        model.addAttribute("curriculum", new CurriculumDto());
        model.addAttribute("disciplineList", disciplineService.findAll());
        model.addAttribute("massage", massage);
        model.addAttribute("nameButton", nameButton);
        return "termCreating";
    }

    @RequestMapping(value = "/termModifying/{nameId}", method = RequestMethod.GET)
    public String disciplineModifying(ModelMap model,
                                      @PathVariable("nameId") int nameId) {
        String massage = "Для модификации семестра отредактируйте данные и нажмите кнопку  \"Применить\" ";
        String nameButton = "Применить";
        Term modifyingTerm = termService.findByName(nameId);
        model.addAttribute("curriculum", new CurriculumDto());
        model.addAttribute("modifyingTerm", modifyingTerm);
        model.addAttribute("disciplineList", disciplineService.findAll());
        model.addAttribute("massage", massage);
        model.addAttribute("nameButton", nameButton);
        return "termCreating";
    }


    @RequestMapping(value = "/termSave", method = RequestMethod.POST)
    public String saveTerm(@ModelAttribute("curriculum") CurriculumDto dto, BindingResult result) {
        int nameTerm;
        if (termService.findAll().size() > 0) {
            nameTerm = termService.findAll().get(termService.findAll().size() - 1).getNumberTerm() + 1;
        } else {
            nameTerm = 1;
        }
        int week = dto.getWeek();
        termService.add(new Term(nameTerm, week));
        for (String str : dto.getDisciplineList()) {
            Term term = termService.findByName(nameTerm);
            Discipline discipline = disciplineService.findByName(str);
            curriculumService.add(term, discipline);
        }
        return "redirect:/term/termsList";
    }

    @RequestMapping(value = "/termModifying/termSave", method = RequestMethod.POST)
    public String termModifyingSave(@ModelAttribute("curriculum") CurriculumDto dto, BindingResult result) throws ParseException {
        Term termModifying = termService.findById(dto.getId());
        int week = dto.getWeek();
        int nameTerm = termModifying.getNumberTerm();
        termModifying.setWeek(week);
        termService.add(termModifying);

        for (Curriculum curriculum : curriculumService.findByTerm(nameTerm)) {
            Term term = termService.findByName(nameTerm);

            Discipline discipline = disciplineService.findByName(str);


        }


        curriculumService.add(term, discipline);
    }

    return"redirect:/term/termsList";
}
}
