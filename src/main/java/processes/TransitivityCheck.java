package processes;

import models.ComparisonMatrix;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Set;
import java.util.stream.Collectors;

public class TransitivityCheck {
    public boolean isHolds(ComparisonMatrix matrix) {
        return checkTransitivity(matrix.getLessThanRelation())
                && checkTransitivity(matrix.getEqualRelation())
                && checkTransitivity(matrix.getMoreRelation());
    }

    private boolean checkTransitivity(Set<Pair<String, String>> set) {
        for (Pair<String, String> outer : set)
        {
            for (Pair<String, String> inner : except(outer, set)) {
                if (!outer.getLeft().equals(inner.getRight())) {
                    if (!set.contains(Pair.of(outer.getLeft(), inner.getRight())) && !set.contains(Pair.of(inner.getRight(), outer.getLeft())))
                        return false;
                }
            }
        }

        return true;
    }

    private <T> Set<T> except(T elem, Set<T> set)
    {
        return set.stream()
                .filter(e -> !e.equals(elem))
                .collect(Collectors.toSet());
    }
}
