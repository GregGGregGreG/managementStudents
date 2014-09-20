package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.repository.DisciplineRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class DisciplineService {
    @Autowired
    public DisciplineRepository repository;
    private Logger logger = Logger.getLogger(DisciplineService.class);

    public void add(Discipline discipline) {
        repository.saveAndFlush(discipline);
    }

    public void remove(Discipline discipline) {
        repository.delete(discipline);
    }

    public List<Discipline> findAll() {
        return repository.findAll();
    }

    public Discipline findByName(String name) {
        return repository.findByName(name);
    }

    public Discipline findById(long id) {
        return repository.findById(id);
    }

}
