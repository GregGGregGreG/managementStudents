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

    @Override
    public String toString() {
        return "TermDisciplineID{" +
                "term=" + term +
                ", discipline=" + discipline +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TermDisciplineID that = (TermDisciplineID) o;

        if (discipline != null ? !discipline.equals(that.discipline) : that.discipline != null) return false;
        if (term != null ? !term.equals(that.term) : that.term != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = term != null ? term.hashCode() : 0;
        result = 31 * result + (discipline != null ? discipline.hashCode() : 0);
        return result;
    }
}
