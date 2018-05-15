package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
public class Criterion {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private int weight;
    @Getter
    private String type;
    @Getter
    private String optimalType;
    @Getter
    private String unit;
    @Getter
    private String scale;
    @Getter
    @Setter
    private Iterable<Mark> marks;
}
