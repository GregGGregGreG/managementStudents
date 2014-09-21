package greg.studentProgress.dto;

import java.io.Serializable;
import java.util.List;

public class CurriculumDto implements Serializable {
    private Long id;
    private String nameTerm;
    private int week;
    private List<String> disciplineList;

    public String getNameTerm() {
        return nameTerm;
    }

    public void setNameTerm(String nameTerm) {
        this.nameTerm = nameTerm;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public List<String> getDisciplineList() {
        return disciplineList;
    }

    public void setDisciplineList(List<String> disciplineList) {
        this.disciplineList = disciplineList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurriculumDto that = (CurriculumDto) o;

        if (week != that.week) return false;
        if (disciplineList != null ? !disciplineList.equals(that.disciplineList) : that.disciplineList != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nameTerm != null ? !nameTerm.equals(that.nameTerm) : that.nameTerm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameTerm != null ? nameTerm.hashCode() : 0);
        result = 31 * result + week;
        result = 31 * result + (disciplineList != null ? disciplineList.hashCode() : 0);
        return result;
    }
}
