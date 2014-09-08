package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface GroupsRepository extends JpaRepository<Groups, Long> {

    @Query("select s from Groups s where s.name=:name")
    Groups findByName(@Param("name") String name);

}
