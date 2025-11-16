package hei.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Course {
    final private int id;
    final private String label;
    final private int credits;
    final private Teacher teacher;
}
