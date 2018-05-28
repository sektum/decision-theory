package entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.tuple.Pair;


@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Simpson {
    @Getter
    private Pair<Long, Long> pair;
    @Getter
    @Setter
    private long count = 0;

    public void incrementCount()
    {
        count++;
    }
}
