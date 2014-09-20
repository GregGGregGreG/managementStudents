package greg.studentProgress.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Collections;
import java.util.Set;

@Entity
public class Groups extends AbstractEntity {
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "groups", fetch = FetchType.LAZY, orphanRemoval = true)
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

}
