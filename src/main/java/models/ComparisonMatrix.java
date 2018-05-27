package models;

import org.apache.commons.lang3.tuple.Pair;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;

public class ComparisonMatrix {
    private Map<String, Map<String, ComparisonResult>> matrix = new LinkedHashMap<>();

    public ComparisonMatrix put(String alt1, String alt2, ComparisonResult result)
    {
        matrix.putIfAbsent(alt1, createInitialMap(alt1));
        matrix.putIfAbsent(alt2, createInitialMap(alt2));
        matrix.get(alt1).put(alt2, result);
        matrix.get(alt2).put(alt1, result.reverse());

        return this;
    }

    public boolean isEmpty()
    {
        return matrix.isEmpty();
    }

    public Map<String, Integer> getResults()
    {
        return matrix.keySet().stream()
                .map(key -> new AbstractMap.SimpleEntry<>(key, Collections.frequency(matrix.get(key).values(), MORE)))
                .sorted(comparing(Map.Entry::getValue, reverseOrder()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
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

    public Set<Pair<String, String>> getLessThanRelation()
    {
        return getRelation(LESS);
    }

    public Set<Pair<String, String>> getEqualRelation()
    {
        return getRelation(EQUAL);
    }

    public Set<Pair<String, String>> getMoreRelation()
    {
        return getRelation(MORE);
    }

    private Set<Pair<String, String>> getRelation(ComparisonResult result)
    {
        return getRelations().stream()
                .filter(r -> r.getResult().equals(result))
                .map(r -> Pair.of(r.getA(), r.getB()))
                .collect(toSet());
    }

    public Set<Relation> getRelations() {
        return matrix.entrySet().stream()
                .flatMap(outerEntry ->
                        outerEntry.getValue().entrySet().stream()
                                .map(innerEntry -> new Relation(outerEntry.getKey(), innerEntry.getKey(), innerEntry.getValue()))
                )
                .filter(relation -> !relation.getA().equals(relation.getB()))
                .collect(toSet());
    }

    private Map<String, ComparisonResult> createInitialMap(String alternative)
    {
        Map<String, ComparisonResult> map = new LinkedHashMap<>();
        map.put(alternative, EQUAL);

        return map;
    }
}
