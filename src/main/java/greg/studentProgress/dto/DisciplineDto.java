package greg.studentProgress.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class DisciplineDto implements Serializable {
    private Long id;
    @NotEmpty(message = "Название дисциплины не должно быть пустым")
    @Size(min = 3,max = 45,message = "Минимальная длина 3 символа максимальная 45")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
