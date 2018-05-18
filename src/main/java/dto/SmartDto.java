package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class SmartDto {
    @Getter
    private String pairName;
    @Getter
    private Map<String, List<String>> pairs;
}
