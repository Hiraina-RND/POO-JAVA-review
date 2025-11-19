package hei.notes;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeTest {

    @Test
    void getExamGradeTest() throws InterruptedException {
        Tutor tutor = new Tutor(1, "PATRICIA", "Sahala", LocalDate.of(1991, 05, 02 ),"felaniana@gmail.com", "0380707340", "Mère");
        Teacher teacher = new Teacher(1, "RAKOTO", "Manga", LocalDate.of(1990, 04, 12), "rakoto@gmail.com", "0320000000", "Back-end");
        Student student = new Student(1, "RANDRIAMIARIMBOLA", "Hiraina", LocalDate.of(2007, 06, 19), "hei.hiraina@gmail.com", "0380937496", "K3", tutor);
        Course prog1 = new Course(1, "PROG1", 8, teacher);
        Exam exam = new Exam(1, "examen PROG1", prog1, LocalDateTime.now(), 8);
        Grade grade = new Grade(student, exam, 13.00, "Initial grade");

        Thread.sleep(10);
        grade.updateGrade(15.00, "For reclamation");
        Thread.sleep(10);
        grade.updateGrade(17.00, "For reclamation");


        Instant t = grade
                .getHistories()
                .get(grade.getHistories().size() - 1)
                .getDate()
                .atZone(ZoneId.systemDefault())
                .toInstant();

        assertEquals(17.00, grade.getExamGrade(t));
    }


    @Test
    void getCourseGradeTest() throws InterruptedException{
        Tutor tutor = new Tutor(1, "PATRICIA", "Sahala", LocalDate.of(1991, 05, 02 ),"felaniana@gmail.com", "0380707340", "Mère");
        Teacher teacher = new Teacher(1, "RAKOTO", "Manga", LocalDate.of(1990, 04, 12), "rakoto@gmail.com", "0320000000", "Back-end");
        Student student = new Student(1, "RANDRIAMIARIMBOLA", "Hiraina", LocalDate.of(2007, 06, 19), "hei.hiraina@gmail.com", "0380937496", "K3", tutor);
        Course prog1 = new Course(1, "PROG1", 8, teacher);
        Course web1 = new Course(2, "WEB1", 8, teacher);
        Exam exam = new Exam(1, "examen PROG1", prog1, LocalDateTime.now(), 8);
        Exam examWeb1 = new Exam(1, "examen WEB1", web1, LocalDateTime.now(), 8);
        Grade grade = new Grade(student, exam, 13.00, "Initial grade");
        Grade web1Grade = new Grade(student, examWeb1, 14.00, "Initial grade");


        Thread.sleep(10);
        grade.updateGrade(15.00, "For reclamation");
        Thread.sleep(10);
        grade.updateGrade(17.00, "For reclamation");
        Thread.sleep(10);
        web1Grade.updateGrade(18.00, "For reclamation");


        Instant t = web1Grade
                .getHistories()
                .get(web1Grade.getHistories().size() - 1)
                .getDate()
                .atZone(ZoneId.systemDefault())
                .toInstant();

        assertEquals(18.00, web1Grade.getCourseGrade(web1, t));
    }
}
