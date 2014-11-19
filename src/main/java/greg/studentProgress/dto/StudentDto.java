package greg.studentProgress.dto;


import greg.studentProgress.persistence.domain.Student;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class StudentDto implements Serializable {
    private Long id;
    @NotEmpty(message = "Фамилия не может быть пустой.")
    @Size(min = 3, max = 45, message = "Минимальная длина 3 символа максимальная 45")
    @Pattern(regexp = "^[А-Яа-яЁё]+$",message = "Имя на русском")
    private String lastName;
    @NotEmpty(message = "Имя не может быть пустым.")
    @Size(min = 2, max = 45, message = "Минимальная длина 3 символа максимальная 45")
    @Pattern(regexp = "^[А-Яа-яЁё]+$",message = "Фамилия на русском")
    private String firstName;
    @NotNull(message = "Год поступления не может быть пустым.")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Past
    private Date weekOfEntry;
    @NotEmpty(message = "Группа не может быть пустой.")
    private String groups;

    public StudentDto() {
    }

    public StudentDto(Student student) {
        this.id = student.getId();
        this.lastName = student.getLastName();
        this.firstName = student.getFirstName();
        this.weekOfEntry = student.getWeekOfEntry();
        this.groups = student.getGroups().getName();
    }

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

    public Date getWeekOfEntry() {
        return weekOfEntry;
    }

    public void setWeekOfEntry(Date weekOfEntry) {
        this.weekOfEntry = weekOfEntry;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups(String groups) {
        this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
