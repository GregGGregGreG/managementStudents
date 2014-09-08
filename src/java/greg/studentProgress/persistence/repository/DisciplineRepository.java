package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline, Long> {

//    @Query("select d from Discipline d where d.discipline = :name")
//    Discipline findByName(@Param("name") String name);
}
