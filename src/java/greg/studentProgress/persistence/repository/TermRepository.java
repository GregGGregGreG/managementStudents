package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<Term, Long> {


}
