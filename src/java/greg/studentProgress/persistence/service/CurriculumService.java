package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.repository.CurriculumRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurriculumService {

    @Autowired
    public CurriculumRepository repository;



    private Logger logger = Logger.getLogger(CurriculumService.class);

    public void create(Curriculum curriculum) {
        repository.saveAndFlush(curriculum);
        logger.info("Created discipline : " + curriculum);
    }

    public void remove(Curriculum curriculum) {
        repository.delete(curriculum);
        logger.info("Remove discipline : " + curriculum);
    }


}
