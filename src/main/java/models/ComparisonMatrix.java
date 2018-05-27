package models;

import org.apache.commons.lang3.tuple.Pair;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingLong;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;
import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;

public class ComparisonMatrix {
    private Map<String, Map<String, ComparisonResult>> matrix = new LinkedHashMap<>();

    public ComparisonMatrix put(String alt1, String alt2, ComparisonResult result)
    {
        matrix.putIfAbsent(alt1, new LinkedHashMap<>());
        matrix.putIfAbsent(alt2, new LinkedHashMap<>());
        matrix.get(alt1).put(alt2, result);

        return this;
    }

    public boolean isEmpty()
    {
        return matrix.isEmpty();
    }

    public Map<String, Long> getResults()
    {
        Map<String, Long> map1 = getMoreRelation().stream()
                .collect(Collectors.groupingBy(Pair::getKey, counting()));
        Map<String, Long> map2 = getLessThanRelation().stream()
                .collect(Collectors.groupingBy(Pair::getValue, counting()));
        Map<String, Long> map3 = Stream.of(map1, map2).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a + b));

        getAlternatives().forEach(alt -> map3.putIfAbsent(alt, 0L));

        return map3;
    }

    public ComparisonResult get(String alt1, String alt2)
    {
        if (alt1.equals(alt2))
            return EQUAL;
        if (matrix.get(alt1) == null)
            return null;
        if (matrix.get(alt1).get(alt2) == null)
            return matrix.get(alt2).get(alt1).reverse();
        return matrix.get(alt1).get(alt2);
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
}
