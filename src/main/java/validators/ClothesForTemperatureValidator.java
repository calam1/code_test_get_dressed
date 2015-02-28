package validators;

public interface ClothesForTemperatureValidator<T> {
    boolean validClothesForWeather(T domain);
}
