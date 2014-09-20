package greg.studentProgress.controller;

import greg.studentProgress.dto.StudentDto;
import greg.studentProgress.dto.StudentProgressDto;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
@SessionAttributes("modifyingStudent")
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
    public ModelAndView studentList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentsList");
        modelAndView.addObject("students", studentService.findAll());
        return modelAndView;
    }

    @RequestMapping(value = "/handlerListsStudents", method = RequestMethod.POST)
    public String handlerListsStudents(@RequestParam(value = "id", required = false) long[] id,
                                       @RequestParam String action,
                                       @ModelAttribute Student modifyingStudent,
                                       RedirectAttributes redirectAttributes) {
        if (!(id == null)) {
            switch (action) {
                case "remove":
                    for (long currID : id) {
                        studentService.remove(studentService.findById(currID));
                    }
                    break;
                case "modifying":
                    for (long currID : id) {
                        String massage = "Для модификации студента заполните все поля и нажмите кнопку  \"Применить\" ";
                        String nameButton = "Применить";
                        modifyingStudent = (studentService.findById(currID));
                        redirectAttributes.addFlashAttribute("student", modifyingStudent);
                        redirectAttributes.addFlashAttribute("modifyingStudent", modifyingStudent);
                        redirectAttributes.addFlashAttribute("massage", massage);
                        redirectAttributes.addFlashAttribute("nameButton", nameButton);
                    }
                    return "redirect:/student/studentModifying";
                case "studentListProgress":
                    for (long currID : id) {
                        redirectAttributes.addFlashAttribute("modifyingStudent", studentService.findById(currID));
                    }
                    return "redirect:/student/studentProgress";
            }
        }
        if (action.equals("creating")) {
            return "redirect:/student/studentCreating";
        }
        return "redirect:/student/studentsList";
    }

    @RequestMapping(value = "/studentProgress", method = RequestMethod.GET)
    public String studentProgress(ModelMap model,
                                  @ModelAttribute StudentProgressDto dto) {
        long studentId = dto.getStudentId();
        long termId = dto.getTermId();

        List<StudentProgress> studentProgressList = studentProgressService.getDisciplineForStudentInTerm(studentId, termId);

        double allRating = 0;
        int numberOfRatings = 0;

        for (StudentProgress progress : studentProgressList) {
            numberOfRatings++;
            allRating += progress.getRating();
        }

        double averageRating = allRating / numberOfRatings;
        if (averageRating < 0) averageRating = 0;

        model.addAttribute("SPDto", new StudentProgressDto());
        model.addAttribute("termList", termService.findAll());
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("studentProgressList", studentProgressList);
        return "studentProgress";
    }

    @RequestMapping(value = "/studentCreating", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        String massage = "Для создпния студента заполните все поля и нажмите кнопку \"Cоздать\"";
        String nameButton = "Создать";
        model.addAttribute("student", new StudentDto());
        model.addAttribute("modifyingStudent", new Student());
        model.addAttribute("massage", massage);
        model.addAttribute("nameButton", nameButton);
        return "studentCreating";
    }
    @RequestMapping(value = "/studentModifying", method = RequestMethod.GET)
    public String modifyingStudent(ModelMap model) {
        return "studentCreating";
    }

    @RequestMapping(value = "/studentSave", method = RequestMethod.POST)
    public String studentSave(@ModelAttribute("student") StudentDto dto, BindingResult result) throws ParseException {
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
