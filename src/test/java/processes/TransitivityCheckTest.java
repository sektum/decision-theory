package processes;

import models.ComparisonMatrix;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransitivityCheckTest {
    public static final String A = "A";
    public static final String B = "B";
    public static final String C = "C";
    private TransitivityCheck transitivityCheck = new TransitivityCheck();

    @ParameterizedTest
    @MethodSource("matrices")
    public void shouldCheckTransitivity(ComparisonMatrix matrix, boolean expected)
    {
        //when
        boolean actual = transitivityCheck.isHolds(matrix);

        //then
        assertEquals(expected, actual);
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
                )
        );
    }
}
