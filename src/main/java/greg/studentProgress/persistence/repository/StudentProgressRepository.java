package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.CurriculumStudentTermID;
import greg.studentProgress.persistence.domain.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentProgressRepository extends JpaRepository<StudentProgress, CurriculumStudentTermID> {

    @Query("select sp from StudentProgress sp where sp.pk.student.id=:studentId and sp.pk.curriculum.pk.term.id=:termId")
    List<StudentProgress> getDisciplineForStudentInTerm(@Param("studentId") Long studentId, @Param("termId") Long termId);

    @Query ("select avg(sp.rating) from StudentProgress sp where sp.pk.student.id=:studentId and sp.pk.curriculum.pk.term.id=:termId")
    Double getAverageRatingForStudentInTerm(@Param("studentId") Long studentId, @Param("termId") Long termId);
}
