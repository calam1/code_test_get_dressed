package helpers.impl;

import commands.Temperature;
import helpers.TemperatureProcessor;

public class TemperatureProcessorImpl implements TemperatureProcessor {
    @Override
    public Temperature mapTemperature(String value) {
        Temperature temperature;
        String passedInTemp = value;
        if (passedInTemp.equalsIgnoreCase("HOT")) {
            temperature = Temperature.HOT;
        } else if (passedInTemp.equalsIgnoreCase("COLD")) {
            temperature = Temperature.COLD;
        }else {
            throw new RuntimeException("Temperature you passed: " + value + " is not recognized; please use hot or cold only");
        }

        return temperature;
    }
}
