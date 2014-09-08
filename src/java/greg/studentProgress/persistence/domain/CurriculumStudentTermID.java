package greg.studentProgress.persistence.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by GreG on 04.09.2014.
 */
@Embeddable
public class CurriculumStudentTermID implements Serializable {
    @ManyToOne
    private Student student;
    @ManyToOne
    private Curriculum curriculum;

    public CurriculumStudentTermID() {
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

}
