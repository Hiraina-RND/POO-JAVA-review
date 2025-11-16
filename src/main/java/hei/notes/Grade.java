package hei.notes;

import lombok.Getter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Getter

public class Grade {
    final private Student student;
    final private Exam exam;
    private double currentValue;
    final private List<NoteHistory> histories = new ArrayList<>();


    public Grade(Student student, Exam exam, double initialValue, String reason) {
        this.student = student;
        this.exam = exam;
        this.currentValue = initialValue;
        this.histories.add(new NoteHistory(initialValue, LocalDateTime.now(), reason));
    }

    public void updateGrade(double newValue, String reason) {
        this.currentValue = newValue;
        this.histories.add(new NoteHistory(newValue, LocalDateTime.now(), reason));
    }

    public double getExamGrade(Instant t) {
        for (NoteHistory noteHistory : histories) {

            Instant dateAsInstant = noteHistory
                    .getDate()
                    .atZone(ZoneId.systemDefault())
                    .toInstant();

            if (dateAsInstant.equals(t)) {
                return  noteHistory.getValue();
            }
        }
        throw new IllegalArgumentException(
                "No grade found for the specified instant."
        );
    }

    public double getCourseGrade(Course course, Instant t) {
        if (this.getExam().getCourse().equals(course)) {

            for (NoteHistory noteHistory : histories) {

                Instant dateAsInstant = noteHistory
                        .getDate()
                        .atZone(ZoneId.systemDefault())
                        .toInstant();

                if (dateAsInstant.equals(t)) {
                    return  noteHistory.getValue();
                }
            }

        }
        throw new IllegalArgumentException(
                "Course not found."
        );
    }
}
