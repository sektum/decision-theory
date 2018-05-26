package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static models.ComparisonResult.EQUAL;

public class ComparisonMatrix {
    private Map<String, Map<String, ComparisonResult>> matrix = new LinkedHashMap<>();

    public void put(String alt1, String alt2, ComparisonResult result)
    {
        matrix.putIfAbsent(alt1, createInitialMap(alt1));
        matrix.putIfAbsent(alt2, createInitialMap(alt2));
        matrix.get(alt1).put(alt2, result);
        matrix.get(alt2).put(alt1, result.reverse());
    }

    public boolean isEmpty()
    {
        return matrix.isEmpty();
    }

    public ComparisonResult get(String alt1, String alt2)
    {
        return Optional.ofNullable(matrix.get(alt1))
                .map(map -> map.get(alt2))
                .orElse(null);
    }

    public List<String> getAlternatives()
    {
        return new ArrayList<>(matrix.keySet());
    }

    private Map<String, ComparisonResult> createInitialMap(String alternative)
    {
        Map<String, ComparisonResult> map = new LinkedHashMap<>();
        map.put(alternative, EQUAL);

        return map;
    }
}
