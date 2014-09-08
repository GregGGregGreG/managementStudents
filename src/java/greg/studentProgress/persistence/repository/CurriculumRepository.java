package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.TermDisciplineID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CurriculumRepository extends JpaRepository<Curriculum, TermDisciplineID> {

}
