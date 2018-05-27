package models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Relation {
    private String a;
    private String b;
    private ComparisonResult result;

    public boolean isLessThan()
    {
        return result == ComparisonResult.LESS;
    }

    public boolean isMoreThan()
    {
        return result == ComparisonResult.MORE;
    }

    public boolean isEquals()
    {
        return result == ComparisonResult.EQUAL;
    }
}
