package greg.studentProgress.persistence.repository;

import greg.studentProgress.persistence.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.firstName=:name")
    Student findByName(@Param("name") String name);

    @Query("select s from Student s where s.id=:id")
    Student findById(@Param("id") Long id);
}
