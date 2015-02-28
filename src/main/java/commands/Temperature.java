package commands;

public enum Temperature {
    HOT("HOT"),
    COLD("COLD");

    private final String temperature;

    Temperature(String temperature) {
        this.temperature = temperature;
    }
}
