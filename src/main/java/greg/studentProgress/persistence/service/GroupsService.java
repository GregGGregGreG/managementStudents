package greg.studentProgress.persistence.service;

import greg.studentProgress.persistence.domain.Groups;
import greg.studentProgress.persistence.repository.GroupsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class GroupsService {
    @Autowired
    private GroupsRepository repository;
    private Logger logger = Logger.getLogger(GroupsService.class);

    public void add(Groups groups) {
        repository.saveAndFlush(groups);
    }

    public void remove(Groups groups) {
        repository.delete(groups);
    }

    public List<Groups> findAll() {
        return repository.findAll();
    }

    public Groups findByName(String name) {
        return repository.findByName(name);
    }
}
