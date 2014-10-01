package greg.studentProgress.dto;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class StudentProgressListDto implements Serializable {
    private Long studentId;
    private Long termId;
    private List<StudentProgressDto> progressDtoList = Collections.emptyList();

    public StudentProgressListDto() {

    }

    public StudentProgressListDto(List<StudentProgressDto> progressDtoList) {
        this.progressDtoList = progressDtoList;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public List<StudentProgressDto> getProgressDtoList() {
        return progressDtoList;
    }

    public void setProgressDtoList(List<StudentProgressDto> progressDtoList) {
        this.progressDtoList = progressDtoList;
    }

}
