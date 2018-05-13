package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Alternative {
    @Getter
    private long id;
    @Getter
    private String name;
}
