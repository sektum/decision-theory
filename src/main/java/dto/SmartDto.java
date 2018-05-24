package dto;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SmartDto {
    @Getter
    private Map<Pair<String, String>, String> matrix = new LinkedHashMap<>();
}
