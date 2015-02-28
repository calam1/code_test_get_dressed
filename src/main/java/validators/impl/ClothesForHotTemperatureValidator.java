package validators.impl;

import commands.MorningActions;
import domains.Person;
import commands.Temperature;
import validators.ClothesForTemperatureValidator;
import validators.ValidationElement;

import java.util.List;

public class ClothesForHotTemperatureValidator implements ClothesForTemperatureValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean validClothesForWeather(Person person) {
        List<MorningActions> myClothes = person.getMyMorningActions();
        if (person.getTemperature() == Temperature.HOT) {
            if (myClothes.contains(MorningActions.PUT_ON_SOCKS) ||
                    myClothes.contains(MorningActions.PUT_ON_JACKET))
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
            List<MorningActions> morningActions = person.getMyMorningActions();
            int socksIndex = morningActions.contains(MorningActions.PUT_ON_SOCKS) ? morningActions.indexOf(MorningActions.PUT_ON_SOCKS) : Integer.MAX_VALUE;
            int jacketIndex = morningActions.contains(MorningActions.PUT_ON_JACKET) ? morningActions.indexOf(MorningActions.PUT_ON_JACKET) : Integer.MAX_VALUE;

            return socksIndex > jacketIndex ? jacketIndex : socksIndex;
        }

        return person.getMyMorningActions().size();
    }
}
