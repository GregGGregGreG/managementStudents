package greg.studentProgress.dto;

import java.util.Collections;
import java.util.List;

public class StudentProgressListDto {
    private List<StudentProgressDto> progressDtoList = Collections.emptyList();

    public StudentProgressListDto() {
    }

    public StudentProgressListDto(List<StudentProgressDto> progressDtoList) {
        this.progressDtoList = progressDtoList;
    }

    public List<StudentProgressDto> getProgressDtoList() {
        return progressDtoList;
    }

    public void setProgressDtoList(List<StudentProgressDto> progressDtoList) {
        this.progressDtoList = progressDtoList;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProgressListDto that = (StudentProgressListDto) o;

        if (progressDtoList != null ? !progressDtoList.equals(that.progressDtoList) : that.progressDtoList != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return progressDtoList != null ? progressDtoList.hashCode() : 0;
    }
}
