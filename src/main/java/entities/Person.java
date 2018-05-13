package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Person {
    @Getter
    private long id;
    @Getter
    private String name;
    @Getter
    private int range;
}
