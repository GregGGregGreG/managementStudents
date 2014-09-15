package greg.studentProgress.persistence.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Curriculum {
    @EmbeddedId
    private TermDisciplineID pk = new TermDisciplineID();

    public Curriculum() {
    }

    public Curriculum(TermDisciplineID pk) {
        this.pk = pk;
    }

    public TermDisciplineID getPk() {
        return pk;
    }

    public void setPk(TermDisciplineID pk) {
        this.pk = pk;
    }

    @Transient
    public Discipline getDiscipline() {
        return getPk().getDiscipline();
    }

    public void setDiscipline(Discipline discipline) {
        getPk().setDiscipline(discipline);
    }

    @Transient
    public Term getTerm() {
        return getPk().getTerm();
    }

    public void setTerm(Term term) {
        getPk().setTerm(term);
    }

}
