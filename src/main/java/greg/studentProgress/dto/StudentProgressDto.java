package greg.studentProgress.dto;

public class StudentProgressDto {
    private long studentId;
    private long termId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public long getTermId() {
        return termId;
    }

    public void setTermId(long termId) {
        this.termId = termId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProgressDto that = (StudentProgressDto) o;

        if (studentId != that.studentId) return false;
        if (termId != that.termId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (studentId ^ (studentId >>> 32));
        result = 31 * result + (int) (termId ^ (termId >>> 32));
        return result;
    }
}
