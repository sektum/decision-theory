package entities;

public enum ScaleType {
    ORDINAL("Ранговая"), INTERVAL("Интервальная"), RATIO("Балльная"), NOMINAL("Номинальная");

    private String value;

    ScaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
