package greg.studentProgress.dto;

import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.domain.StudentProgress;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StudentProgressDto implements Serializable {
    private Student student;
    private Long termId;
    private double averageRating;
    private List<StudentProgress> studentProgressList = Collections.emptyList();

    public StudentProgressDto() {

    }

    public StudentProgressDto(Student student) {
        this.student = student;
    }

    public StudentProgressDto(Student student, Long termId) {
        this.student = student;
        this.termId = termId;
    }

    public StudentProgressDto(Student student, Long termId, double averageRating, List<StudentProgress> studentProgressList) {
        this.student = student;
        this.termId = termId;
        this.averageRating = averageRating;
        this.studentProgressList = studentProgressList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<StudentProgress> getStudentProgressList() {
        return studentProgressList;
    }

    public void setStudentProgressList(List<StudentProgress> studentProgressList) {
        this.studentProgressList = studentProgressList;
    }

}
