package greg.studentProgress.persistence.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.Date;
import java.util.Set;


@Entity
public class Student extends AbstractEntity {
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    @Temporal(value = TemporalType.DATE)
    private Date weekOfEntry;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Groups groups;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.student", orphanRemoval=true)
    private Set<StudentProgress> studentProgresses = Collections.emptySet();

    public Student() {

    }

    public Student(String firstName, String lastName, Date weekOfEntry, Groups groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weekOfEntry = weekOfEntry;
        this.groups = groups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getWeekOfEntry() {
        return weekOfEntry;
    }

    public void setWeekOfEntry(Date week_of_entry) {
        this.weekOfEntry = week_of_entry;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public Set<StudentProgress> getStudentProgresses() {
        return studentProgresses;
    }

    public void setStudentProgresses(Set<StudentProgress> studentProgresses) {
        this.studentProgresses = studentProgresses;
    }


}
