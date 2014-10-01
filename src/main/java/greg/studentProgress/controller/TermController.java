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

import javax.validation.Valid;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
    public String termList(ModelMap model, @ModelAttribute("curriculum") CurriculumDto dto) {
        model.addAttribute("terms", termService.findAll());
        return "termsList";
    }

    @RequestMapping(value = "/termsList/{nameTerm}", method = RequestMethod.GET)
    public String termListId(ModelMap model, @PathVariable("nameTerm") int nameTerm) {
        model.addAttribute("curriculum", new CurriculumDto());
        model.addAttribute("terms", termService.findAll());
        model.addAttribute("listDiscipline", curriculumService.findByTerm(nameTerm));
        model.addAttribute("weekTerm", termService.findByName(nameTerm));
        model.addAttribute("termId", termService.findByName(nameTerm).getId());
        model.addAttribute("nameTerm",nameTerm );
        return "termsList";
    }

    @RequestMapping(value = "termsList/admin/handlerTermsList", method = RequestMethod.POST)
    public String studentProgressList(@ModelAttribute("curriculum") CurriculumDto dto, @RequestParam String action) {
        switch (action) {
            case "remove":
                termService.remove(termService.findById(dto.getId()));
                return "redirect:/term/termsList/";
            case "modifying":
                return "redirect:/term/admin/termModifying/" + dto.getId();
            case "creating":
                return "redirect:/term/admin/termCreating";
        }
        return "redirect:/term/termsList/" + dto.getNameTerm();
    }

    @RequestMapping(value = "/admin/termCreating", method = RequestMethod.GET)
    public String termCreating(ModelMap model, @ModelAttribute("curriculum") CurriculumDto dto) {
        model.addAttribute("disciplineList", disciplineService.findAll());
        return "termCreating";
    }

    @RequestMapping(value = "/admin/termModifying/{termId}", method = RequestMethod.GET)
    public String disciplineModifying(ModelMap model, @PathVariable("termId") Long termId,
                                      @ModelAttribute("curriculum") CurriculumDto dto) {
        Term term = termService.findById(termId);
        CurriculumDto modifyingCurriculum = new CurriculumDto();
        modifyingCurriculum.setId(term.getId());
        modifyingCurriculum.setWeek(term.getWeek());
        model.addAttribute("modifyingCurriculum", modifyingCurriculum);
        model.addAttribute("disciplineList", disciplineService.findAll());
        return "termCreating";
    }

    @RequestMapping(value = "admin/termCreating", method = RequestMethod.POST)
    public String saveTerm(ModelMap model, @Valid @ModelAttribute("curriculum") CurriculumDto dto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("disciplineList", disciplineService.findAll());
            return "termCreating";
        }
        int nameTerm = 1;
        List<Term> termList = termService.findAll();
        if (termList.size() > 0) {
            nameTerm = termList.get(termList.size() - 1).getNumberTerm() + 1;
        }

        int week = dto.getWeek();
        termService.add(new Term(nameTerm, week));
        Term term = termService.findByName(nameTerm);
        for (String str : dto.getDisciplineList()) {
            Discipline discipline = disciplineService.findByName(str);
            curriculumService.add(term, discipline);
        }
        return "redirect:/term/termsList/" + nameTerm;
    }

    @RequestMapping(value = "admin/termModifying/{termId}", method = RequestMethod.POST)
    public String termModifyingSave(ModelMap model, @PathVariable("termId") Long termId, @Valid @ModelAttribute("curriculum") CurriculumDto dto, BindingResult result) throws ParseException {
        if (result.hasErrors()) {
            Term term = termService.findById(termId);
            CurriculumDto modifyingCurriculum = new CurriculumDto();
            modifyingCurriculum.setId(term.getId());
            model.addAttribute("modifyingCurriculum", modifyingCurriculum);
            model.addAttribute("disciplineList", disciplineService.findAll());
            return "termCreating";
        }

        Term termModifying = termService.findById(termId);
        int week = dto.getWeek();
        int nameTerm = termModifying.getNumberTerm();
        termModifying.setWeek(week);
        termService.add(termModifying);

        List<Curriculum> curriculumList = curriculumService.findByTerm(nameTerm);
        ArrayList<String> curriculumListNameDiscipline = new ArrayList<>();
        int curriculumListSize = curriculumList.size();

        for (Curriculum curriculum : curriculumList) {
            curriculumListNameDiscipline.add(curriculum.getDiscipline().getName());
        }

        List<String> disciplineList = dto.getDisciplineList();
        int disciplineListSize = disciplineList.size();

        if (disciplineListSize > curriculumListSize) {
            for (String discipline : disciplineList) {
                if (!(curriculumListNameDiscipline.contains(discipline))) {
                    curriculumService.add(termService.findByName(nameTerm), disciplineService.findByName(discipline));
                }
            }
        } else {
            for (String discipline : curriculumListNameDiscipline) {
                if (!(disciplineList.contains(discipline))) {
                    curriculumService.remove(curriculumService.getCurriculum(nameTerm, discipline));
                }
            }
        }
        return "redirect:/term/termsList/" + nameTerm;
    }
}

