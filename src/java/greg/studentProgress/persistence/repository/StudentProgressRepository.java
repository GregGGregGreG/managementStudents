package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.CurriculumStudentTermID;
import greg.studentProgress.persistence.domain.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentProgressRepository extends JpaRepository<StudentProgress, CurriculumStudentTermID> {

    @Query("select sp from StudentProgress sp where sp.pk.student.firstName =:name")
    List<StudentProgress> getStudentProgressName(@Param("name") String name);


}
