package entities;

import models.ComparisonResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static models.ComparisonResult.EQUAL;
import static models.ComparisonResult.LESS;
import static models.ComparisonResult.MORE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComparisonResultTest {
    @ParameterizedTest
    @MethodSource("signsProvider")
    public void shouldCorrectlyReverseOperations(ComparisonResult result, ComparisonResult reverse)
    {
        //then
        assertEquals(result.reverse(), reverse);
    }

    private static Stream<Arguments> signsProvider()
    {
        return Stream.of(
                Arguments.of(LESS, MORE),
                Arguments.of(EQUAL, EQUAL),
                Arguments.of(MORE, LESS)
        );
    }
}
