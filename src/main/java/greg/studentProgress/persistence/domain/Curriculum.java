package greg.studentProgress.persistence.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
public class Curriculum {
    @EmbeddedId
    private TermDisciplineID pk = new TermDisciplineID();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "pk.curriculum")
    private Set<StudentProgress> studentProgress = Collections.emptySet();

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

    public Set<StudentProgress> getStudentProgress() {
        return studentProgress;
    }

    public void setStudentProgress(Set<StudentProgress> studentProgress) {
        this.studentProgress = studentProgress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Curriculum that = (Curriculum) o;

        if (pk != null ? !pk.equals(that.pk) : that.pk != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return pk != null ? pk.hashCode() : 0;
    }
}
