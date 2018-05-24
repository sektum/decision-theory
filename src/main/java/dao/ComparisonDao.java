package dao;

import entities.ComparisonResult;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class ComparisonDao {
    private static Map<Pair<String, String>, ComparisonResult> MATRIX = new LinkedHashMap<>();

    public void saveComparison(String param1, String param2, ComparisonResult result)
    {
        MATRIX.put(Pair.of(param1, param2), result);
    }

    public Map<Pair<String, String>, ComparisonResult> getComparisonMatrix()
    {
        return MATRIX;
    }

    public List<String> getComparedAlternatives()
    {
        List<Pair<String, String>> pairs = new ArrayList<>(MATRIX.keySet());
        return pairs.stream()
                .map(Pair::getKey)
                .distinct()
                .collect(toList());
    }
}
