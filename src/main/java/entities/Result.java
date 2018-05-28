package entities;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Result {
    @Getter
    private int idLpr;
    @Getter
    private long idAlt;
    @Getter
    private long aWeight;
}
