package entities;

public enum ScaleType {
    ORDINAL("Порядковая шкала"), INTERVAL("Интервальная"), RATIO("Абсолютная шкала"), NOMINAL("Шкала наименований");

    private String value;

    ScaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
