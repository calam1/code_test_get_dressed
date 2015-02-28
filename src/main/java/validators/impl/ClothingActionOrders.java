package validators.impl;

import commands.ClothingActions;
import commands.Person;
import validators.ActionOrders;
import validators.ValidationElement;

import java.util.List;

public class ClothingActionOrders implements ActionOrders<Person>, ValidationElement<Person> {
    @Override
    public boolean areActionsInTheCorrectOrder(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();

        if (myClothes.contains(ClothingActions.FOOTWEAR) && myClothes.contains(ClothingActions.SOCKS)) {
            if (myClothes.indexOf(ClothingActions.SOCKS) > myClothes.indexOf(ClothingActions.FOOTWEAR))
                return false;
        }

        if (myClothes.contains(ClothingActions.SHIRT) && myClothes.contains(ClothingActions.HEADWEAR)) {
            if (myClothes.indexOf(ClothingActions.SHIRT) > myClothes.indexOf(ClothingActions.HEADWEAR))
                return false;

        }

        if (myClothes.contains(ClothingActions.SHIRT) && myClothes.contains(ClothingActions.JACKET)) {
            if (myClothes.indexOf(ClothingActions.SHIRT) > myClothes.indexOf(ClothingActions.JACKET))
                return false;
        }

        if (myClothes.contains(ClothingActions.PANTS) && myClothes.contains(ClothingActions.FOOTWEAR)) {
            if (myClothes.indexOf(ClothingActions.PANTS) > myClothes.indexOf(ClothingActions.FOOTWEAR))
                return false;
        }

        return true;
    }

    @Override
    public boolean validate(Person person) {
        return areActionsInTheCorrectOrder(person);
    }
}
