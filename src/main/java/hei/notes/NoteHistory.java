package hei.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor

public class NoteHistory {
    final private double value;
    final private LocalDateTime date;
    final private String reason;
}
