package factory;

import commands.Temperature;

public interface TemperatureProcessor {
    Temperature mapTemperature(String temperature);
}
