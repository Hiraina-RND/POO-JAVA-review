package hei.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class Exam {
    final private int id;
    final private String title;
    final private Course course;
    final private LocalDateTime date;
    final private int coefficient;
}
