package validators.impl;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import validators.FailedIndex;
import validators.ValidClothesForTemperature;
import validators.ValidationElement;

import java.util.List;

public class ValidClothesForHotTemperature implements ValidClothesForTemperature<Person>, ValidationElement<Person>, FailedIndex<Person> {
    @Override
    public boolean validClothesForWeather(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();
        if (person.getTemperature() == Temperature.HOT) {
            if (myClothes.contains(ClothingActions.SOCKS) ||
                    myClothes.contains(ClothingActions.JACKET))
                return false;
        }

        return true;
    }

    @Override
    public boolean validate(Person person) {
        return validClothesForWeather(person);
    }

    @Override
    public int findIndexOfCollectionForValidationFailure(Person person) {
        if (!validate(person)){
            List<ClothingActions> clothingActions = person.getMyClothes();
            int socksIndex = clothingActions.contains(ClothingActions.SOCKS) ? clothingActions.indexOf(ClothingActions.SOCKS) : Integer.MAX_VALUE;
            int jacketIndex = clothingActions.contains(ClothingActions.JACKET) ? clothingActions.indexOf(ClothingActions.JACKET) : Integer.MAX_VALUE;

            return socksIndex > jacketIndex ? jacketIndex : socksIndex;
        }

        return 0;
    }
}
