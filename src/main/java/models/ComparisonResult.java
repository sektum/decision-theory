package models;

import java.util.stream.Stream;

public enum ComparisonResult {
    LESS("<"), EQUAL("="), MORE(">");

    private String sign;

    ComparisonResult(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    public static ComparisonResult fromSign(String sign)
    {
        return Stream.of(values()).filter(result -> result.sign.equals(sign)).findAny().get();
    }

    public ComparisonResult reverse()
    {
        if (this == LESS)
            return MORE;
        if (this == MORE)
            return LESS;
        return EQUAL;
    }
}
