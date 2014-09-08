package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.repository.DisciplineRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GreG on 04.09.2014.
 */
@Service
public class DisciplineService {

    @Autowired
    public DisciplineRepository repository;

    private Logger logger = Logger.getLogger(DisciplineService.class);

    public void create(Discipline discipline) {
        repository.saveAndFlush(discipline);
        logger.info("Created discipline : " + discipline);
    }

    public void remove(Discipline discipline) {
        repository.delete(discipline);
        logger.info("Remove discipline : " + discipline);
    }

    public Discipline findByName(String name) {
        logger.info("Find by name start");
        return repository.findByName(name);
    }
}
