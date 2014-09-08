package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreG on 04.09.2014.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    private Logger logger = Logger.getLogger(StudentService.class);

    public void create(Student student) {
        repository.saveAndFlush(student);
        logger.info("Created student : " + student);
    }

    public void remove(Student student) {
        repository.delete(student);
        logger.info("Remove student : " + student);
    }

    public Student findByName(String name) {
        logger.info("Find by name start");
        return repository.findByName(name);
    }



}
