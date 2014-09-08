package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.TermDisciplineID;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CurriculumRepository extends JpaRepository<Curriculum, TermDisciplineID> {


}
