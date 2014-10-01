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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProgressDto that = (StudentProgressDto) o;

        if (Double.compare(that.averageRating, averageRating) != 0) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;
        if (studentProgressList != null ? !studentProgressList.equals(that.studentProgressList) : that.studentProgressList != null)
            return false;
        if (termId != null ? !termId.equals(that.termId) : that.termId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = student != null ? student.hashCode() : 0;
        result = 31 * result + (termId != null ? termId.hashCode() : 0);
        temp = Double.doubleToLongBits(averageRating);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (studentProgressList != null ? studentProgressList.hashCode() : 0);
        return result;
    }
}
