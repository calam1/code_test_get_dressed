package validators.impl;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import validators.ClothesForTemperatureValidator;
import validators.ValidationElement;

import java.util.List;

public class ClothesForHotTemperatureValidator implements ClothesForTemperatureValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean validClothesForWeather(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();
        if (person.getTemperature() == Temperature.HOT) {
            if (myClothes.contains(ClothingActions.PUT_ON_SOCKS) ||
                    myClothes.contains(ClothingActions.PUT_ON_JACKET))
                return false;
        }

        return true;
    }

    @Override
    public boolean validate(Person person) {
        return validClothesForWeather(person);
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person person) {
        if (!validate(person)){
            List<ClothingActions> clothingActions = person.getMyClothes();
            int socksIndex = clothingActions.contains(ClothingActions.PUT_ON_SOCKS) ? clothingActions.indexOf(ClothingActions.PUT_ON_SOCKS) : Integer.MAX_VALUE;
            int jacketIndex = clothingActions.contains(ClothingActions.PUT_ON_JACKET) ? clothingActions.indexOf(ClothingActions.PUT_ON_JACKET) : Integer.MAX_VALUE;

            return socksIndex > jacketIndex ? jacketIndex : socksIndex;
        }

        return person.getMyClothes().size();
    }
}
