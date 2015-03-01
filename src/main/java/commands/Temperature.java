package commands;

public enum Temperature {
    HOT("HOT"),
    COLD("COLD");

    private final String temperature;

    Temperature(String temperature) {
        this.temperature = temperature;
    }

    public static Temperature getTemperature(String temp){
        switch (temp) {
            case "HOT" : return Temperature.HOT;

            case "COLD" : return Temperature.COLD;

            default :
                throw new RuntimeException("passed in invalid value for Temperature enum");
        }
    }
}
