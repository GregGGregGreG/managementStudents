package greg.studentProgress.controller;

import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.service.StudentService;
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
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student, BindingResult result) {
        studentService.add(student);
        return "redirect:/student/studentsList";
    }
}
