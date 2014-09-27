package greg.studentProgress.controller;

import greg.studentProgress.dto.StudentDto;
import greg.studentProgress.dto.StudentProgressDto;
import greg.studentProgress.dto.StudentProgressListDto;
import greg.studentProgress.persistence.domain.Groups;
import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.service.GroupsService;
import greg.studentProgress.persistence.service.StudentProgressService;
import greg.studentProgress.persistence.service.StudentService;
import greg.studentProgress.persistence.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private GroupsService groupsService;
    @Autowired
    private StudentProgressService studentProgressService;
    @Autowired
    private TermService termService;

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public String studentList(ModelMap model) {
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }

    @RequestMapping(value = "/handlerListsStudents", method = RequestMethod.POST)
    public String handlerListsStudents(@RequestParam(value = "id", required = false) Long[] id,
                                       @RequestParam String action,
                                       RedirectAttributes redirectAttrs) {
        if (!(id == null)) {
            switch (action) {
                case "remove":
                    for (Long currID : id) {
                        studentService.remove(studentService.findById(currID));
                    }
                    break;
                case "modifying":
                    for (Long currID : id) {
                        return "redirect:/student/admin/studentModifying/" + currID;
                    }
                case "studentListProgress":
                    redirectAttrs.addAttribute("id", id);
                    return "redirect:/student/studentProgress/{id}";
            }
        }
        if (action.equals("creating")) {
            return "redirect:/student/admin/studentCreating";
        }
        return "redirect:/student/studentsList";
    }

    @RequestMapping(value = "/studentProgress/{id}", method = RequestMethod.GET)
    public String studentProgress(ModelMap model,
                                  @PathVariable("id") Long[] userId,
                                  @ModelAttribute StudentProgressDto dto) {

        List<StudentProgressDto> dtoList = new ArrayList<>();

        for (Long studentId : userId) {
            if (studentId.equals(dto.getStudentId())) {
                Long termId = dto.getTermId();

            }
        }

        for (Long studentId : userId) {
            Long termId = 1L;
            if (studentId.equals(dto.getStudentId())) {
                termId = dto.getTermId();
            }
            if (!(studentProgressService.getAverageRatingForStudentInTerm(studentId, termId) == null)) {
                Double averageRating = studentProgressService.getAverageRatingForStudentInTerm(studentId, termId);
                dtoList.add(new StudentProgressDto(studentService.findById(studentId), averageRating, studentProgressService.getDisciplineForStudentInTerm(studentId, termId)));
            } else {
                dtoList.add(new StudentProgressDto(studentService.findById(studentId), studentProgressService.getDisciplineForStudentInTerm(studentId, termId)));
            }
        }


        model.addAttribute("StudentProgressListDto", new StudentProgressListDto(dtoList));
        model.addAttribute("termList", termService.findAll());
        model.addAttribute("StudentProgressDto", new StudentProgressDto());


        return "studentProgress";
    }

    @RequestMapping(value = "/admin/studentCreating", method = RequestMethod.GET)
    public String studentCreating(ModelMap model) {
        model.addAttribute("student", new StudentDto());
        return "studentCreating";
    }

    @RequestMapping(value = "/admin/studentModifying/{userId}", method = RequestMethod.GET)
    public String studentModifying(ModelMap model,
                                   @PathVariable("userId") Long userId) {
        Student modifyingStudent = (studentService.findById(userId));
        model.addAttribute("student", new StudentDto(modifyingStudent));
        return "studentCreating";
    }

    @RequestMapping(value = "/admin/studentSave", method = RequestMethod.POST)
    public String studentSave(@Valid @ModelAttribute("student") StudentDto dto, BindingResult result) throws ParseException {
        if (result.hasErrors()) {
            return "studentCreating";
        }

        Student student = studentService.findById(dto.getId());
        if (student == null) {
            student = new Student();
        }


        String lastName = dto.getLastName();
        String firstName = dto.getFirstName();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String dateInString = dto.getWeekOfEntry();
        Date weekOfEntry = sdf.parse(dateInString);

        String groups = dto.getGroups();
        Groups group = groupsService.findByName(groups);

        student.setAllParam(firstName, lastName, weekOfEntry, group);
        studentService.add(student);
        return "redirect:/student/studentsList";

    }
 }
