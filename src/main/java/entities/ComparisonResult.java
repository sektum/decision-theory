package entities;

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
}
