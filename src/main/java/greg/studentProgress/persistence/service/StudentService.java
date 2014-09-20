package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Student;
import greg.studentProgress.persistence.repository.StudentRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentRepository repository;
    @Autowired
    private GroupsService groupsService;
    private Logger logger = Logger.getLogger(StudentService.class);

    public void add(Student student) {
        repository.saveAndFlush(student);
    }

    public void remove(Student student) {
        repository.delete(student);
    }

    public Student findById(Long id) {
        return repository.findById(id);
    }

    public Student findByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findAll() {
        return repository.findAll();
    }
}
