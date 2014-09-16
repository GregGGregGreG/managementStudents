package greg.studentProgress.controller;

import greg.studentProgress.dto.StudentDto;
import greg.studentProgress.persistence.domain.Groups;
import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.service.GroupsService;
import greg.studentProgress.persistence.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private GroupsService groupsService;

    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("students", studentService.findAll());
        return "studentsList";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new StudentDto());
        return "addStudent";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") StudentDto studentDto, BindingResult result) throws ParseException {
        String studentDtoLastName = studentDto.getLastName();
        String studentDtoFirstName = studentDto.getFirstName();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String dateInString = studentDto.getWeekOfEntry();
        Date studentDtoWeekOfEntry = sdf.parse(dateInString);

        String studentDtoGroups = studentDto.getGroups();

        Groups group = groupsService.findByName(studentDtoGroups);
        Student student = new Student(studentDtoFirstName, studentDtoLastName, studentDtoWeekOfEntry, group);
        studentService.add(student);
        return "redirect:/student/studentsList";
    }
}
