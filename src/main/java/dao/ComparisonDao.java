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

    public void saveComparison(String param1, String param2, ComparisonResult result) {
        MATRIX.put(Pair.of(param1, param2), result);
    }

    public String[][] getComparisonMatrix() {
        int size = getComparedAlternatives().size() + 1;
        String[][] comparisonMatrix = new String[size][size];
        for(int i=1; i<size; i++) {
            for(int j=0; j<i; j++) {
                String cp = "";
                cp = MATRIX.get(Pair.of(getComparedAlternatives().get(i), getComparedAlternatives().get(j))).getSign();
                comparisonMatrix[i][j] = cp;
                if (ComparisonResult.fromSign(cp).equals(ComparisonResult.LESS))
                    comparisonMatrix[i][j] = ComparisonResult.MORE.getSign();
                if (ComparisonResult.fromSign(cp).equals(ComparisonResult.MORE))
                    comparisonMatrix[i][j] = ComparisonResult.LESS.getSign();
                if (ComparisonResult.fromSign(cp).equals(ComparisonResult.EQUAL))
                    comparisonMatrix[i][j] = ComparisonResult.EQUAL.getSign();
            }
        }
        for (int k = 0; k < size; k++) {
            comparisonMatrix[k][k] = ComparisonResult.EQUAL.getSign();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(comparisonMatrix[i][j] + " ");
            }
            System.out.println();
        }
        return comparisonMatrix;
    }

    public List<String> getComparedAlternatives() {
        List<Pair<String, String>> pairs = new ArrayList<>(MATRIX.keySet());
        return pairs.stream()
                .map(Pair::getKey)
                .distinct()
                .collect(toList());
    }
}
