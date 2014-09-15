package greg.studentProgress.persistence.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CurriculumStudentTermID implements Serializable {
    @ManyToOne
    private Student student;
    @ManyToOne
    private Curriculum curriculum;

    public CurriculumStudentTermID() {
    }

    public CurriculumStudentTermID(Student student, Curriculum curriculum) {
        this.student = student;
        this.curriculum = curriculum;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Curriculum getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurriculumStudentTermID that = (CurriculumStudentTermID) o;

        if (curriculum != null ? !curriculum.equals(that.curriculum) : that.curriculum != null) return false;
        if (student != null ? !student.equals(that.student) : that.student != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = student != null ? student.hashCode() : 0;
        result = 31 * result + (curriculum != null ? curriculum.hashCode() : 0);
        return result;
    }
}
