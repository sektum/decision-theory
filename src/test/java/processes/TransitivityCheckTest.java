package processes;

import models.ComparisonMatrix;
import models.ComparisonResult;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransitivityCheckTest {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    public static final String D = "alt4";
    public static final String E = "alt5";
    private TransitivityCheck transitivityCheck = new TransitivityCheck();

    @ParameterizedTest
    @MethodSource("matrices")
    public void shouldCheckTransitivity(ComparisonMatrix matrix, boolean expected)
    {
        //when
        Pair<Boolean, Map<ComparisonResult, List<String>>> actual = transitivityCheck.isHolds(matrix);

        //then
        assertEquals(expected, actual.getKey());
    }

    private static Stream<Arguments> matrices()
    {
        return Stream.of(
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, MORE),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, MORE)
                        .put(B, C, MORE)
                        .put(A, C, MORE),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, MORE)
                        .put(B, C, MORE)
                        .put(A, C, LESS),
                        false
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, EQUAL)
                        .put(B, C, EQUAL)
                        .put(A, C, MORE),
                        false
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, LESS)
                        .put(B, C, MORE)
                        .put(A, C, LESS),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, LESS)
                        .put(B, C, MORE)
                        .put(A, C, MORE),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, LESS)
                        .put(B, C, MORE)
                        .put(A, C, EQUAL),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, EQUAL)
                        .put(A, C, EQUAL)
                        .put(A, D, EQUAL)
                        .put(A, E, EQUAL)
                        .put(B, C, EQUAL)
                        .put(B, D, EQUAL)
                        .put(B, E, EQUAL)
                        .put(C, E, EQUAL)
                        .put(C, D, EQUAL),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, LESS)
                        .put(A, C, MORE)
                        .put(A, D, EQUAL)
                        .put(A, E, EQUAL)
                        .put(B, C, MORE)
                        .put(B, D, MORE)
                        .put(B, E, MORE)
                        .put(C, D, LESS)
                        .put(C, E, LESS)
                        .put(D, E, EQUAL),
                        true
                ),
                Arguments.of(
                        new ComparisonMatrix()
                        .put(A, B, LESS)
                        .put(A, C, MORE)
                        .put(A, D, LESS)
                        .put(A, E, LESS)
                        .put(B, C, MORE)
                        .put(B, D, MORE)
                        .put(B, E, MORE)
                        .put(C, D, LESS)
                        .put(C, E, LESS)
                        .put(D, E, MORE),
                        true
                )
        );
    }
}
