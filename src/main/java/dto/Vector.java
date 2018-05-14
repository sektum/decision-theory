package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
public class Vector {
    @Getter
    private String altName;
    @Getter
    private Map<String, String> marks;
}
