package validators.impl;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import validators.LeaveTheHouseValidator;
import validators.ValidationElement;

import java.util.List;

public class LeaveTheHouseFullyClothedValidator implements LeaveTheHouseValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean canILeaveTheHouse(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();
        if (!amILeavingTheHouseAndStillDressing(myClothes) &&
            doIHaveTheCorrectAmountOfClothingActions(person)) {
            return true;
        }

        return false;
    }

    private boolean amILeavingTheHouseAndStillDressing(List<ClothingActions> myClothes) {

        if (myClothes.size() > 0 &&
            myClothes.contains(ClothingActions.LEAVE_HOUSE) &&
            myClothes.get(myClothes.size() - 1) != ClothingActions.LEAVE_HOUSE) return true;

        return false;
    }

    private boolean doIHaveTheCorrectAmountOfClothingActions(Person person) {
        if (person.getTemperature() == Temperature.COLD) {
            if (person.getMyClothes().size() != 8)
                return false;
        } else {
            if (person.getMyClothes().size() != 6)
                return false;
        }
        return true;
    }

    @Override
    public boolean validate(Person person) {
        return canILeaveTheHouse(person);
    }
}
