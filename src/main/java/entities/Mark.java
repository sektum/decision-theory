package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Mark {
    @Getter
    private long id;
    @Getter
    private long critId;
    @Getter
    private String name;
    @Getter
    private int range;
    @Getter
    private int number;
    @Getter
    private int normalized;
}
