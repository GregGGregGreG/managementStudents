package greg.studentProgress.persistence.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.Set;

/**
 * Created by GreG on 03.09.2014.
 */
@Entity

public class Discipline extends AbstractEntity {
    private String discipline;
    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL ,mappedBy = "pk.discipline")
    private Set<Curriculum> ciCurriculums = Collections.emptySet();

    public Discipline() {
        super();
    }

    public Discipline(String discipline, Set<Curriculum> ciCurriculums) {
        this.discipline = discipline;
        this.ciCurriculums = ciCurriculums;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public Set<Curriculum> getCiCurriculums() {
        return ciCurriculums;
    }

    public void setCiCurriculums(Set<Curriculum> ciCurriculums) {
        this.ciCurriculums = ciCurriculums;
    }
}
