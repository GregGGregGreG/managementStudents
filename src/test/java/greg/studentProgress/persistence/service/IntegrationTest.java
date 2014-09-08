package greg.studentProgress.persistence.service;

import greg.studentProgress.config.PersistenceConfig;
import greg.studentProgress.persistence.domain.Curriculum;
import greg.studentProgress.persistence.domain.Discipline;
import greg.studentProgress.persistence.domain.Term;
import greg.studentProgress.persistence.domain.TermDisciplineID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceConfig.class)
public class IntegrationTest {
    @Resource
    private DisciplineService disciplineService;
    @Resource
    private TermService termService;
    @Resource
    private CurriculumService curriculumService;


    @Test
    public void addDisciplineTest() {
        disciplineService.create(new Discipline("Programming"));
        termService.create(new Term(1, 18));
        curriculumService.create(new Curriculum(new TermDisciplineID(termService.findByName(1), disciplineService.findByName("Programming"))));
    }
}
