package greg.studentProgress.persistence.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
public class Term extends AbstractEntity {
    @Column(nullable = false)
    private int numberTerm;
    @Column(nullable = false)
    private int week;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "pk.term")
    private Set<Curriculum> curriculum = Collections.emptySet();

    public Term() {
        super();
    }

    public Term(int numberTerm, int week) {
        this.numberTerm = numberTerm;
        this.week = week;
    }

    public int getNumberTerm() {
        return numberTerm;
    }

    public void setNumberTerm(int numberTerm) {
        this.numberTerm = numberTerm;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Set<Curriculum> getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(Set<Curriculum> curriculum) {
        this.curriculum = curriculum;
    }
}
