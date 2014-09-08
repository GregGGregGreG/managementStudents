package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Term;
import greg.studentProgress.persistence.repository.TermRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreG on 04.09.2014.
 */
@Service
public class TermService {

    @Autowired
    private TermRepository repository;

    private Logger logger = Logger.getLogger(TermService.class);

    public void create(Term term) {
        repository.saveAndFlush(term);
        logger.debug("Created term : " + term);
    }

    public void remove(Term term) {
        repository.delete(term);
        logger.debug("Remove term : " + term);
    }

    public Term findByName(int term) {
        logger.debug("Find by name start");
        return repository.findByName(term);
    }
}
