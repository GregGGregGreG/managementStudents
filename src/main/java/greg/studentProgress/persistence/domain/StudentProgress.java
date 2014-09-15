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


}
