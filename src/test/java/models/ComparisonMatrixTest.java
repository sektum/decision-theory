package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonMatrixTest {
    public static final String ALT_3 = "alt3";
    private ComparisonMatrix matrix;
    public static final String ALT_1 = "alt1";
    public static final String ALT_2 = "alt2";

    @BeforeEach
    public void setUp()
    {
        matrix = new ComparisonMatrix();
    }

    @Test
    public void shouldSaveResults()
    {
        //given
        ComparisonResult result = LESS;

        //when
        matrix.put(ALT_1, ALT_2, result);

        //then
        assertEquals(matrix.get(ALT_1, ALT_2), LESS);
    }

    @Test
    public void shouldCorrectlyRevertOperations()
    {
        //given
        ComparisonResult result = LESS;
        ComparisonResult reverseResult = MORE;

        //when
        matrix.put(ALT_1, ALT_2, result);

        //then
        assertEquals(matrix.get(ALT_2, ALT_1), reverseResult);
    }

    @Test
    public void shouldReturnAllAlternatives()
    {
        //when
        matrix.put(ALT_1, ALT_2, LESS);

        //then
        assertEquals(matrix.getAlternatives(), Arrays.asList(ALT_1, ALT_2));
    }

    @Test
    public void shouldSetComparisonToItself()
    {
        //when
        matrix.put(ALT_1, ALT_2, LESS);

        //then
        assertEquals(matrix.get(ALT_1, ALT_1), EQUAL);
        assertEquals(matrix.get(ALT_2, ALT_2), EQUAL);
        assertEquals(matrix.get(ALT_3, ALT_3), null);
    }

    @Test
    public void shouldHandleMultipleEntries()
    {
        //when
        matrix.put(ALT_1, ALT_2, LESS);
        matrix.put(ALT_2, ALT_3, MORE);

        //then
        Map<String, ComparisonResult> alt1Comparisons = new HashMap<>();
        alt1Comparisons.put(ALT_1, EQUAL);
        alt1Comparisons.put(ALT_2, LESS);
        assertEquals(matrix.getComparisons(ALT_1), alt1Comparisons);

        Map<String, ComparisonResult> alt2Comparisons = new HashMap<>();
        alt2Comparisons.put(ALT_1, MORE);
        alt2Comparisons.put(ALT_2, EQUAL);
        alt2Comparisons.put(ALT_3, MORE);
        assertEquals(matrix.getComparisons(ALT_2), alt2Comparisons);

        Map<String, ComparisonResult> alt3Comparisons = new HashMap<>();
        alt3Comparisons.put(ALT_2, LESS);
        alt3Comparisons.put(ALT_3, EQUAL);
        assertEquals(matrix.getComparisons(ALT_3), alt3Comparisons);
    }
}
