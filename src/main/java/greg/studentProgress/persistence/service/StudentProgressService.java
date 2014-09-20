package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.StudentProgress;
import greg.studentProgress.persistence.repository.StudentProgressRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentProgressService {
    @Autowired
    private StudentProgressRepository repository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private CurriculumService curriculumService;
    private Logger logger = Logger.getLogger(StudentProgressService.class);

    public void add(StudentProgress progress) {
        repository.saveAndFlush(progress);
    }

    public void remove(StudentProgress studentProgress) {
        repository.delete(studentProgress);
    }

    public List<StudentProgress> getDisciplineForStudentInTerm(long studentId,long termId) {
        return repository.getDisciplineForStudentInTerm(studentId,termId);
    }

    public List<StudentProgress> findAll() {
        return repository.findAll();
    }

}
