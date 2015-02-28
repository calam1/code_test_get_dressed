package validators.impl;

import commands.MorningActions;
import domains.Person;
import validators.ActionOrdersValidator;
import validators.ValidationElement;

import java.util.List;

public class ClothingActionOrdersValidator implements ActionOrdersValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean areActionsInTheCorrectOrder(Person person) {
        List<MorningActions> myClothes = person.getMyMorningActions();

        if (myClothes.contains(MorningActions.PUT_ON_FOOTWEAR) && myClothes.contains(MorningActions.PUT_ON_SOCKS)) {
            if (myClothes.indexOf(MorningActions.PUT_ON_SOCKS) > myClothes.indexOf(MorningActions.PUT_ON_FOOTWEAR))
                return false;
        }

        if (myClothes.contains(MorningActions.PUT_ON_SHIRT) && myClothes.contains(MorningActions.PUT_ON_HEAD_WEAR)) {
            if (myClothes.indexOf(MorningActions.PUT_ON_SHIRT) > myClothes.indexOf(MorningActions.PUT_ON_HEAD_WEAR))
                return false;

        }

        if (myClothes.contains(MorningActions.PUT_ON_SHIRT) && myClothes.contains(MorningActions.PUT_ON_JACKET)) {
            if (myClothes.indexOf(MorningActions.PUT_ON_SHIRT) > myClothes.indexOf(MorningActions.PUT_ON_JACKET))
                return false;
        }

        if (myClothes.contains(MorningActions.PUT_ON_PANTS) && myClothes.contains(MorningActions.PUT_ON_FOOTWEAR)) {
            if (myClothes.indexOf(MorningActions.PUT_ON_PANTS) > myClothes.indexOf(MorningActions.PUT_ON_FOOTWEAR))
                return false;
        }

        return true;
    }

    @Override
    public boolean validate(Person person) {
        return areActionsInTheCorrectOrder(person);
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person domain) {
        return 0;
    }
}
