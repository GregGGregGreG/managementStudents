package greg.studentProgress.dto;


import greg.studentProgress.persistence.domain.Student;

import java.util.List;

public class StudentListDto {
    private List<Student> studentList;

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
