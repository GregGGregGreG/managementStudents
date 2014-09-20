package greg.studentProgress.controller;

import greg.studentProgress.dto.CurriculumDto;
import greg.studentProgress.dto.StudentDto;
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
    private Student modifyingStudent;
    private long termId = 1L;


    @RequestMapping(value = "/studentsList", method = RequestMethod.GET)
    public String listStudent(ModelMap model) {
        model.addAttribute("students", studentService.findAll());
        modifyingStudent = null;
        return "studentsList";
    }

    @RequestMapping(value = "/studentsList/studentProgress", method = RequestMethod.POST)
    public String studentProgressList(@RequestParam(value = "id", required = false) long[] id,
                                      @RequestParam String action,
                                      RedirectAttributes redirectAttributes) {

        if (action.equals("remove")) {
            if (!(id == null)) {
                for (long currID : id) {
                    Student student = studentService.findById(currID);
                    studentService.remove(student);
                }
            }
        } else if (action.equals("modifying")) {
            if (!(id == null)) {
                for (long currID : id) {
                    modifyingStudent = (studentService.findById(currID));
                    redirectAttributes.addFlashAttribute("modifyingStudent", modifyingStudent);
                }
                return "redirect:/student/studentModifying";
            }
        } else if (action.equals("studentListProgress")) {
            if (!(id == null)) {
                for (long currID : id) {
                    modifyingStudent = (studentService.findById(currID));
                }
                return "redirect:/student/studentListProgress";
            }
        }
        return "redirect:/student/studentsList";
    }


    @RequestMapping(value = "/studentCreating", method = RequestMethod.GET)
    public String addStudent(ModelMap model) {
        model.addAttribute("student", new StudentDto());
        return "studentCreating";

    }

    @RequestMapping(value = "/studentListProgress", method = RequestMethod.GET)
    public String studentListProgress(ModelMap model) {
        long studentId = modifyingStudent.getId();


        List<StudentProgress> studentProgressList = studentProgressService.getDisciplineForStudentInTerm(studentId, termId);

        double allRating = 0;
        int numberOfRatings = 0;

        for (StudentProgress progress : studentProgressList) {
            numberOfRatings++;
            allRating += progress.getRating();
        }


        double averageRating = allRating / numberOfRatings;
        if (averageRating < 0) averageRating = 0;

        termId = 1;

        model.addAttribute("term", new CurriculumDto());
        model.addAttribute("termList", termService.findAll());
        model.addAttribute("averageRating", averageRating);
        model.addAttribute("studentProgressList", studentProgressList);
        model.addAttribute("modifyingStudent", modifyingStudent);
        return "studentProgress";

    }

    @RequestMapping(value = "/studentListProgress/showDisciplineInTerm", method = RequestMethod.POST)
    public String listDiscipline(@ModelAttribute("term") CurriculumDto curriculumDto, BindingResult result) {
        termId = Long.parseLong((curriculumDto.getNameTerm()));
        return "redirect:/student/studentListProgress";
    }


    @RequestMapping(value = "/studentModifying", method = RequestMethod.GET)
    public String modifyingStudent(ModelMap model) {
        model.addAttribute("student", new StudentDto());
        return "studentModifying";
    }

    @RequestMapping(value = "/saveStudentModifying", method = RequestMethod.POST)
    public String modifyingStudentSave(@ModelAttribute("student") StudentDto studentDto, BindingResult
            result) throws ParseException {
        modifyingStudent.setFirstName(studentDto.getFirstName());
        modifyingStudent.setLastName(studentDto.getLastName());
        String studentDtoGroups = studentDto.getGroups();
        Groups group = groupsService.findByName(studentDtoGroups);
        modifyingStudent.setGroups(group);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
        String dateInString = studentDto.getWeekOfEntry();
        Date studentDtoWeekOfEntry = sdf.parse(dateInString);
        modifyingStudent.setWeekOfEntry(studentDtoWeekOfEntry);
        studentService.add(modifyingStudent);
        modifyingStudent = null;
        return "redirect:/student/studentsList";
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
