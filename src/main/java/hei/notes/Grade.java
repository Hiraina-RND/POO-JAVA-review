package hei.notes;

import lombok.Getter;

import java.time.LocalDateTime;
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
}
