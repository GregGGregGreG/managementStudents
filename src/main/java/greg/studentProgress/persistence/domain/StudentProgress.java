package greg.studentProgress.persistence.domain;

import javax.persistence.*;

@Entity
public class StudentProgress {
    private int rating;
    @EmbeddedId
    private CurriculumStudentTermID pk = new CurriculumStudentTermID();

    public StudentProgress() {
    }

    public StudentProgress(int rating, CurriculumStudentTermID pk) {
        this.rating = rating;
        this.pk = pk;
    }

    @Transient
    public Curriculum getCurriculum() {
        return getPk().getCurriculum();
    }

    public void setCurriculum(Curriculum curriculum) {
        getPk().setCurriculum(curriculum);
    }

    @Transient
    public Student getStudent() {
        return getPk().getStudent();
    }

    public void setStudent(Student student) {
        getPk().setStudent(student);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CurriculumStudentTermID getPk() {
        return pk;
    }

    public void setPk(CurriculumStudentTermID pk) {
        this.pk = pk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProgress that = (StudentProgress) o;

        if (rating != that.rating) return false;
        if (pk != null ? !pk.equals(that.pk) : that.pk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = rating;
        result = 31 * result + (pk != null ? pk.hashCode() : 0);
        return result;
    }
}
