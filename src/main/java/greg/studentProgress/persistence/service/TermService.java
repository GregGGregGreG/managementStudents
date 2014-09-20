package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Term;
import greg.studentProgress.persistence.repository.TermRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TermService {
    @Autowired
    private TermRepository repository;
    private Logger logger = Logger.getLogger(TermService.class);

    public void add(Term term) {
        repository.saveAndFlush(term);
    }

    public void remove(Term term) {
        repository.delete(term);
    }

    public List<Term> findAll() {
        return repository.findAll();
    }

    public Term findByName(int term) {
        return repository.findByName(term);
    }
}
