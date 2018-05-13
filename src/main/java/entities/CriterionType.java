package entities;

public enum CriterionType {
    QUALITATIVE("Качественный"), QUANTITATIVE("Количественный");

    private String value;

    CriterionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
