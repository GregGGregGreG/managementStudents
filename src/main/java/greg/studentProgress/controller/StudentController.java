package greg.studentProgress.controller;

import greg.studentProgress.dto.StudentDto;
import greg.studentProgress.dto.StudentProgressDto;
import greg.studentProgress.dto.StudentProgressListDto;
import greg.studentProgress.persistence.domain.Groups;
import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.domain.StudentProgress;
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
        model.addAttribute("studentsList", studentService.findAll());
        return "studentsList";
    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.POST, params = "studentListProgress")
    public String studentListProgress(@RequestParam(value = "studentsId", required = false) Long[] studentsId,
                                      RedirectAttributes redirectAttrs) {
        redirectAttrs.addAttribute("studentsId", studentsId);
        return "redirect:/student/studentProgress/{studentsId}";
    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.POST, params = "remove")
    public String removeStudent(@RequestParam(value = "studentsId", required = false) Long[] studentsId) {
        for (Long idStudent : studentsId) {
            studentService.remove(studentService.findById(idStudent));
        }
        return "redirect:/student/studentsList";
    }

    @RequestMapping(value = "/studentsList", method = RequestMethod.POST, params = "modifying")
    public String modifyingStudent(@RequestParam(value = "studentsId", required = false) Long studentsId) {
        return "redirect:/student/admin/studentModifying/" + studentsId;
    }

    @RequestMapping(value = "/studentProgress/{studentsId}", method = RequestMethod.GET)
    public String studentProgress(ModelMap model,
                                  @PathVariable("studentsId") Long[] studentsId,
                                  @ModelAttribute StudentProgressListDto dto,
                                  @RequestParam(value = "termsId", required = false) Long[] termsId,
                                  @RequestParam(value = "term", required = false) Long[] term) {
        List<StudentProgressDto> dtoList = new ArrayList<>();
        if (termsId != null) {
            for (int i = 0; i < studentsId.length; i++) {
                Student student = studentService.findById(studentsId[i]);
                Long studentId = student.getId();
                Long termId = termsId[i];
                if (studentId.equals(dto.getStudentId())) {
                    termId = term[i];
                }
                if (studentProgressService.getAverageRatingForStudentInTerm(studentId, termId) != null) {
                    Double averageRating = studentProgressService.getAverageRatingForStudentInTerm(studentId, termId);
                    List<StudentProgress> studentProgressList = studentProgressService.getDisciplineForStudentInTerm(studentId, termId);
                    dtoList.add(new StudentProgressDto(student, termId, averageRating, studentProgressList));
                } else {
                    dtoList.add(new StudentProgressDto(student, termId));
                }
            }
        } else {
            for (Long studentId : studentsId) {
                Long termId = 1L;
                Student student = studentService.findById(studentId);
                if (!(studentProgressService.getAverageRatingForStudentInTerm(studentId, termId) == null)) {
                    Double averageRating = studentProgressService.getAverageRatingForStudentInTerm(studentId, termId);
                    List<StudentProgress> studentProgressList = studentProgressService.getDisciplineForStudentInTerm(studentId, termId);
                    dtoList.add(new StudentProgressDto(student, termId, averageRating, studentProgressList));
                } else {
                    dtoList.add(new StudentProgressDto(student, termId));
                }
            }
        }
        model.addAttribute("studentProgressListDto", new StudentProgressListDto(dtoList));
        model.addAttribute("termList", termService.findAll());
        return "studentProgress";
    }

    @RequestMapping(value = "/admin/studentCreating", method = RequestMethod.GET)
    public String studentCreating(ModelMap model) {
        model.addAttribute("student", new StudentDto());
        model.addAttribute("groupsList", groupsService.findAll());
        return "studentCreating";
    }

    @RequestMapping(value = "/admin/studentCreating", method = RequestMethod.POST)
    public String studentSave(ModelMap model, @Valid
    @ModelAttribute("student") StudentDto dto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("groupsList", groupsService.findAll());
            return "studentCreating";
        }
        String lastName = dto.getLastName();
        String firstName = dto.getFirstName();
        Date weekOfEntry = dto.getWeekOfEntry();
        Groups group = groupsService.findByName(dto.getGroups());
        studentService.add(new Student(firstName, lastName, weekOfEntry, group));
        return "redirect:/student/studentsList";
    }

    @RequestMapping(value = "/admin/studentModifying/{studentId}", method = RequestMethod.GET)
    public String studentModifying(ModelMap model, @PathVariable("studentId") Long studentId) {
        model.addAttribute("student", studentService.findById(studentId));
        model.addAttribute("groupsList", groupsService.findAll());
        return "studentCreating";
    }

    @RequestMapping(value = "/admin/studentModifying/{studentId}", method = RequestMethod.POST)
    public String studentModifyingSave(ModelMap model, @PathVariable("studentId") Long studentId,
                                       @Valid @ModelAttribute("student") StudentDto dto, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("groupsList", groupsService.findAll());
            return "studentCreating";
        }
        Student student = studentService.findById(studentId);
        String lastName = dto.getLastName();
        String firstName = dto.getFirstName();
        Date weekOfEntry = dto.getWeekOfEntry();
        Groups group = groupsService.findByName(dto.getGroups());
        student.setAllParam(firstName, lastName, weekOfEntry, group);
        studentService.add(student);
        return "redirect:/student/studentsList";
    }
}
