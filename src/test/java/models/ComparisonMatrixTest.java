package models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
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
    }

    @Test
    public void shouldCorrectlyGetRelations()
    {
        //when
        matrix.put(ALT_1, ALT_2, LESS);
        matrix.put(ALT_1, ALT_3, MORE);
        matrix.put(ALT_2, ALT_3, EQUAL);

        //then
        assertEquals(
                new HashSet<>(Arrays.asList(
                        new Relation(ALT_1, ALT_2, LESS),
                        new Relation(ALT_1, ALT_3, MORE),
                        new Relation(ALT_2, ALT_3, EQUAL)
                )),
                matrix.getRelations()
        );
    }

    @Test
    public void shouldReturnCorrectResults()
    {
        //when
        matrix.put(ALT_1, ALT_2, LESS);
        matrix.put(ALT_2, ALT_3, MORE);
        matrix.put(ALT_1, ALT_3, MORE);

        //then
        Map<String, Long> results = matrix.getResults();
        assertEquals(Long.valueOf(1), results.get(ALT_1));
        assertEquals(Long.valueOf(2), results.get(ALT_2));
        assertEquals(Long.valueOf(0), results.get(ALT_3));
    }
}
