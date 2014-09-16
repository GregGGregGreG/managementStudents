package greg.studentProgress.dto;

import java.io.Serializable;

public class StudentDto implements Serializable {
    private String lastName;
    private String firstName;
    private String weekOfEntry;
    private String groups;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getWeekOfEntry() {
        return weekOfEntry;
    }

    public void setWeekOfEntry(String weekOfEntry) {
        this.weekOfEntry = weekOfEntry;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }
}
