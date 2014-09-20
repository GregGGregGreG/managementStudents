package greg.studentProgress.dto;

public class CurriculumDto {
    private String nameTerm;

    public String getNameTerm() {
        return nameTerm;
    }

    public void setNameTerm(String nameTerm) {
        this.nameTerm = nameTerm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurriculumDto that = (CurriculumDto) o;

        if (nameTerm != null ? !nameTerm.equals(that.nameTerm) : that.nameTerm != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return nameTerm != null ? nameTerm.hashCode() : 0;
    }
}
