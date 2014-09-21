package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.domain.Term;
import greg.studentProgress.persistence.domain.TermDisciplineID;
import greg.studentProgress.persistence.repository.CurriculumRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CurriculumService {
    @Autowired
    public CurriculumRepository repository;
    private Logger logger = Logger.getLogger(CurriculumService.class);

    public void add(Term term, Discipline discipline) {
        Objects.requireNonNull(term);
        Objects.requireNonNull(discipline);
        repository.saveAndFlush(new Curriculum(new TermDisciplineID(term, discipline)));
    }

    public void removeList(List<Curriculum> curriculum) {
        repository.delete(curriculum);
        logger.info("Delete curriculum Lst!");
    }

    public void remove(Curriculum curriculum) {
        repository.delete(curriculum);
    }

    public List<Curriculum> findByTerm(int term){
        return repository.findByTerm(term);
    }

    public Curriculum getCurriculum(int term, String discipline) {
        return repository.findCurriculum(term, discipline);
    }

}
