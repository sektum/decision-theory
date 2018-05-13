package entities;

public enum OptimalType {
    MAX("Max"), MIN("Min"), NOT_APPLICABLE("Не применимо");

    private String value;

    OptimalType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
