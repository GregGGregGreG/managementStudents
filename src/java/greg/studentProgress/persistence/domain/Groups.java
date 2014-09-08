package greg.studentProgress.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.Set;

/**
 * Created by GreG on 04.09.2014.
 */
@Entity
public class Groups extends AbstractEntity {
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "groups")
    private Set<Student> students = Collections.emptySet();

    public Groups() {
        super();
    }

    public Groups(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "name='" + name + '\'' +
                '}';
    }
}
