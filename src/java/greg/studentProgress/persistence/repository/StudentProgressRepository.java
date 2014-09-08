package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.CurriculumStudentTermID;
import greg.studentProgress.persistence.domain.StudentProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProgressRepository extends JpaRepository<StudentProgress, CurriculumStudentTermID> {
}
