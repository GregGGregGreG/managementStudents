package greg.studentProgress.dto;

import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.domain.StudentProgress;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StudentProgressDto implements Serializable {
    private Long termId;
    private Long studentId;
    private Student student;
    private double averageRating;
    private List<StudentProgress> studentProgressList = Collections.emptyList();


    public StudentProgressDto() {

    }

    public StudentProgressDto(Student student, List<StudentProgress> studentProgressList) {
        this.student = student;
        this.studentProgressList = studentProgressList;
    }

    public StudentProgressDto(Student student, double averageRating, List<StudentProgress> studentProgressList) {
        this.student = student;
        this.averageRating = averageRating;
        this.studentProgressList = studentProgressList;
    }

    public StudentProgressDto(Long termId, Long studentId, Student student, double averageRating, List<StudentProgress> studentProgressList) {
        this.termId = termId;
        this.studentId = studentId;
        this.student = student;
        this.averageRating = averageRating;
        this.studentProgressList = studentProgressList;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProgressDto that = (StudentProgressDto) o;

        if (student != null ? !student.equals(that.student) : that.student != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return student != null ? student.hashCode() : 0;
    }
}
