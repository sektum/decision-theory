package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Alternative {
    @Getter
    private int id;
    @Getter
    private String name;
}
