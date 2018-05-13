package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Criterion {
    @Getter
    private int id;
    @Getter
    private String name;
    @Getter
    private int weight;
    @Getter
    private CriterionType type;
    @Getter
    private OptimalType optimalType;
    @Getter
    private String unit;
    @Getter
    private ScaleType scale;
}
