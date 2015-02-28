package validators.impl;

import commands.MorningActions;
import domains.Person;
import commands.Temperature;
import validators.LeaveTheHouseValidator;
import validators.ValidationElement;

import java.util.List;

public class LeaveTheHouseFullyClothedValidator implements LeaveTheHouseValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean canILeaveTheHouse(Person person) {
        List<MorningActions> myClothes = person.getMyMorningActions();
        if (!amILeavingTheHouseAndStillDressing(myClothes) &&
            doIHaveTheCorrectAmountOfClothingActions(person)) {
            return true;
        }

        return false;
    }

    private boolean amILeavingTheHouseAndStillDressing(List<MorningActions> myClothes) {

        if (myClothes.size() > 0 &&
            myClothes.contains(MorningActions.LEAVE_HOUSE) &&
            myClothes.get(myClothes.size() - 1) != MorningActions.LEAVE_HOUSE) return true;

        return false;
    }

    private boolean doIHaveTheCorrectAmountOfClothingActions(Person person) {
        if (person.getTemperature() == Temperature.COLD) {
            if (person.getMyMorningActions().size() != 8)
                return false;
        } else {
            if (person.getMyMorningActions().size() != 6)
                return false;
        }
        return true;
    }

    @Override
    public boolean validate(Person person) {
        return canILeaveTheHouse(person);
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person domain) {
        return 0;
    }
}
