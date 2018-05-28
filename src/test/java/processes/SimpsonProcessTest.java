package processes;

import entities.Result;
import entities.Simpson;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpsonProcessTest {
    private SimpsonProcess simpsonProcess = new SimpsonProcess();

    @Test
    public void shouldCorrectlyAddUniqueCombinationOfPairs()
    {
        //when
        simpsonProcess.addSimpsons(asList(
                Result.builder().idAlt(1).build(),
                Result.builder().idAlt(2).build()
                )
        );

        //then
        assertEquals(asList(
                new Simpson(Pair.of(1L, 2L), 1),
                new Simpson(Pair.of(2L, 1L), 1)
        ),
        simpsonProcess.simpsons);
    }

    @Test
    public void shouldCorrectlyAddNonUniquePairs()
    {
        //when
        simpsonProcess.addSimpsons(asList(
                Result.builder().idAlt(1).build(),
                Result.builder().idAlt(2).build(),
                Result.builder().idAlt(1).build()
                )
        );

        //then
        assertThat(simpsonProcess.simpsons).containsOnly(
                new Simpson(Pair.of(1L, 2L), 2),
                new Simpson(Pair.of(2L, 1L),2),
                new Simpson(Pair.of(1L, 1L), 2)
        );
    }
}
