package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@AllArgsConstructor
@ToString
public class VectorDto {
    @Getter
    private String altName;
    @Getter
    private Map<String, String> marks;
}
