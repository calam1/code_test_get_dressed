package validators.impl;

import commands.MorningActions;
import commands.Temperature;
import domains.Person;
import validators.LeaveTheHouseValidator;
import validators.ValidationElement;

import java.util.List;

public class LeaveTheHouseFullyClothedValidator implements LeaveTheHouseValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean canILeaveTheHouse(Person person) {
        List<MorningActions> morningActions = person.getMyMorningActions();
        if (!amILeavingTheHouseAndStillDressing(morningActions) &&
                doIHaveTheCorrectAmountOfClothingActions(person)) {
            return true;
        }

        return false;
    }

    private boolean amILeavingTheHouseAndStillDressing(List<MorningActions> morningActions) {

        if (morningActions.size() > 0 &&
                morningActions.contains(MorningActions.LEAVE_HOUSE) &&
                morningActions.get(morningActions.size() - 1) != MorningActions.LEAVE_HOUSE) return true;

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
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person person) {
        if (!validate(person)) {
            List<MorningActions> morningActions = person.getMyMorningActions();

            if (morningActions.size() > 0 &&
                    morningActions.contains(MorningActions.LEAVE_HOUSE) &&
                    morningActions.get(morningActions.size() - 1) != MorningActions.LEAVE_HOUSE)
                return morningActions.indexOf(MorningActions.LEAVE_HOUSE);

            if (morningActions.contains(MorningActions.LEAVE_HOUSE) &&
                    !doIHaveTheCorrectAmountOfClothingActions(person))
                return morningActions.indexOf(MorningActions.LEAVE_HOUSE);

        }

        return person.getMyMorningActions().size();
    }
}
