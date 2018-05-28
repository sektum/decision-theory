package processes;

import models.ComparisonMatrix;
import models.ComparisonResult;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;

public class TransitivityCheck {
    public Pair<Boolean, Map<ComparisonResult, List<String>>> isHolds(ComparisonMatrix matrix) {
        Pair<Boolean, Pair<String, String>> lessResult = checkTransitivity(matrix.getLessThanRelation());
        Pair<Boolean, Pair<String, String>> equalResult = checkTransitivity(matrix.getEqualRelation());
        Pair<Boolean, Pair<String, String>> moreResult = checkTransitivity(matrix.getMoreRelation());

        Map<ComparisonResult, List<String>> errorMap = new HashMap<>();
        if (lessResult.getValue() != null)
            errorMap.put(LESS, Arrays.asList(lessResult.getValue().getLeft(), lessResult.getValue().getRight()));
        if (equalResult.getValue() != null)
            errorMap.put(EQUAL, Arrays.asList(equalResult.getValue().getLeft(), equalResult.getValue().getRight()));
        if (moreResult.getValue() != null)
            errorMap.put(MORE, Arrays.asList(moreResult.getValue().getLeft(), moreResult.getValue().getRight()));

        return Pair.of(lessResult.getLeft() && equalResult.getLeft() && moreResult.getLeft(), errorMap);
    }

    private Pair<Boolean, Pair<String, String>> checkTransitivity(Set<Pair<String, String>> set) {
        for (Pair<String, String> firstPair : set) {
            for (Pair<String, String> secondPair : except(firstPair, set)) {
                Pair<String, String> thirdPair = Pair.of(firstPair.getLeft(), secondPair.getRight());
                if (!set.contains(thirdPair)) {
                    return Pair.of(false, thirdPair);
                }
            }
        }

        return Pair.of(true, null);
    }

    private Set<Pair<String, String>> except(Pair<String, String> pair, Set<Pair<String, String>> set) {
        return set.stream()
                .filter(p -> p.getLeft().equals(pair.getRight()))
                .collect(Collectors.toSet());
    }
}
