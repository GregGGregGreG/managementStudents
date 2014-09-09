package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.TermDisciplineID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CurriculumRepository extends JpaRepository<Curriculum, TermDisciplineID> {

    @Query("select c from Curriculum c where c.pk.term.numberTerm=:term and c.pk.discipline.name=:name")
    Curriculum findCurriculum(@Param("term") int term, @Param("name") String name);

}
