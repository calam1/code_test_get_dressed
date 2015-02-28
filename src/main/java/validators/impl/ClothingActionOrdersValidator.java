package validators.impl;

import commands.ClothingActions;
import commands.Person;
import validators.ActionOrdersValidator;
import validators.ValidationElement;

import java.util.List;

public class ClothingActionOrdersValidator implements ActionOrdersValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean areActionsInTheCorrectOrder(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();

        if (myClothes.contains(ClothingActions.PUT_ON_FOOTWEAR) && myClothes.contains(ClothingActions.PUT_ON_SOCKS)) {
            if (myClothes.indexOf(ClothingActions.PUT_ON_SOCKS) > myClothes.indexOf(ClothingActions.PUT_ON_FOOTWEAR))
                return false;
        }

        if (myClothes.contains(ClothingActions.PUT_ON_SHIRT) && myClothes.contains(ClothingActions.PUT_ON_HEAD_WEAR)) {
            if (myClothes.indexOf(ClothingActions.PUT_ON_SHIRT) > myClothes.indexOf(ClothingActions.PUT_ON_HEAD_WEAR))
                return false;

        }

        if (myClothes.contains(ClothingActions.PUT_ON_SHIRT) && myClothes.contains(ClothingActions.PUT_ON_JACKET)) {
            if (myClothes.indexOf(ClothingActions.PUT_ON_SHIRT) > myClothes.indexOf(ClothingActions.PUT_ON_JACKET))
                return false;
        }

        if (myClothes.contains(ClothingActions.PUT_ON_PANTS) && myClothes.contains(ClothingActions.PUT_ON_FOOTWEAR)) {
            if (myClothes.indexOf(ClothingActions.PUT_ON_PANTS) > myClothes.indexOf(ClothingActions.PUT_ON_FOOTWEAR))
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
