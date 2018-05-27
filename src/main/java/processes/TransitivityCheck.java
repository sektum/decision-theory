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
                Pair<String, String> pair = Pair.of(outer.getLeft(), inner.getRight());
                if (!pair.getLeft().equals(pair.getRight()) && !set.contains(pair))
                    return false;
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
