package greg.studentProgress.persistence.domain;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Embeddable
public class TermDisciplineID implements Serializable {

    @ManyToOne
    private Term term;

    @ManyToOne
    private Discipline discipline;

    public TermDisciplineID() {

    }

    public TermDisciplineID(Term term, Discipline discipline) {
        this.term = term;
        this.discipline = discipline;
    }

    public Term getTerm() {
        return term;
    }

    public void setTerm(Term term) {
        this.term = term;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

}
