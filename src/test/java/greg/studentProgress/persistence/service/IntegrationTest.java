package greg.studentProgress.persistence.service;

import greg.studentProgress.config.PersistenceConfig;
import greg.studentProgress.persistence.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    @Resource
    private StudentService studentService;
    @Resource
    private GroupsService groupsService;
    @Resource
    private StudentProgressService studentProgressService;

    @Test
    public void addDisciplineTest() {
        disciplineService.add(new Discipline("Programming"));
        termService.add(new Term(1, 18));
        disciplineService.add(new Discipline("Algebra"));
        termService.add(new Term(2, 25));
        curriculumService.add(termService.findByName(1), disciplineService.findByName("Programming"));
        curriculumService.add(termService.findByName(2), disciplineService.findByName("Algebra"));
        curriculumService.add(termService.findByName(1), disciplineService.findByName("Algebra"));
        groupsService.add(new Groups("MN-08-1"));
        Groups group = groupsService.findByName("MN-08-1");
        Student student = new Student("Petr", "Ivanov", new Date(), group);
        studentService.add(student);
        Student studentUpdate = studentService.findByName("Petr");
        studentUpdate.setLastName("Update");
        studentService.add(studentUpdate);
//        studentProgressService.add(95, "Petr", "Algebra", 1);
//        studentProgressService.add(95, "Petr", "Programming", 1);
//        studentProgressService.add(95, "Petr", "Programming", 2);
//        List<StudentProgress> studentProgress = studentProgressService.findByNameStudent("Petr");
//        System.out.println("--------------------------------------------------");
//        for (StudentProgress progress :studentProgress) {
//            System.out.println(progress.getStudent().getFirstName());
//            System.out.println(progress.getStudent().getLastName());
//            System.out.println(progress.getStudent().getGroups().getName());
//            System.out.println(progress.findCurriculum().getDiscipline().getName());
//            System.out.println(progress.findCurriculum().getTerm().getNumberTerm());
//            System.out.println(progress.getRating());
//
//
//      };
        List<Curriculum> curriculumList = curriculumService.findByTerm(1);
        for (Curriculum curriculum : curriculumList) {
            System.out.println(curriculum.getDiscipline().getName());
        }

        curriculumService.remove(curriculumList);

    }


//    @Test
//    public void select() {
//        StudentProgress studentProgress = studentProgressService.findByNameStudent("Petr");
//        System.out.println(studentProgress);
//    }
}
