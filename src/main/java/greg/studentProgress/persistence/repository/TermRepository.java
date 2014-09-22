package greg.studentProgress.persistence.repository;


import greg.studentProgress.persistence.domain.Term;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TermRepository extends JpaRepository<Term, Long> {

    @Query("select t from Term t where t.numberTerm = :term")
    Term findByName(@Param("term") int term);

    @Query("select t from Term t where t.id=:id")
    Term findById(@Param("id") Long id);
}
