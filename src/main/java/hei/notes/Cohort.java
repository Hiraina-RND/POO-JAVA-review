package hei.notes;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor

public class Cohort {
    final private String name;
    final private List<String> groups;
}
