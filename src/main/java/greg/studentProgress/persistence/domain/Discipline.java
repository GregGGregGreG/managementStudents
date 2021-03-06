package greg.studentProgress.persistence.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;


@Entity
public class Discipline extends AbstractEntity {
    @Column(nullable = false)
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "pk.discipline")
    private Set<Curriculum> Curriculums = Collections.emptySet();

    public Discipline() {

    }

    public Discipline(String name) {
        this.name = name;
    }

    public Discipline(String name, Set<Curriculum> Curriculums) {
        this.name = name;
        this.Curriculums = Curriculums;
    }

    public String getName() {
        return name;
    }

    public void setName(String discipline) {
        this.name = discipline;
    }

    public Set<Curriculum> getCurriculums() {
        return Curriculums;
    }

    public void setCurriculums(Set<Curriculum> ciCurriculums) {
        this.Curriculums = ciCurriculums;
    }

    @Override
    public String toString() {
        return name;
    }
}
