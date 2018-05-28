package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.Pair;


@AllArgsConstructor
public class Simpson {
    @Getter
    private Pair<Long, Long> pair;
    @Getter
    @Setter
    private long count = 0;
}
