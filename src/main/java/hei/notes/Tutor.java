package hei.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor

public class Tutor {
    final private int id;
    final private String firstName;
    final private String lastName;
    final private LocalDate birthDate;
    final private String email;
    final private String phoneNumber;
    final private String relationToStudent;
}
