package validators.impl;

import commands.MorningActions;
import domains.Person;
import validators.ActionOrdersValidator;
import validators.ValidationElement;

import java.util.List;

public class ClothingActionOrdersValidator implements ActionOrdersValidator<Person>, ValidationElement<Person> {

    @Override
    public boolean areActionsInTheCorrectOrder(Person person) {
        List<MorningActions> morningActions = person.getMyMorningActions();

        if (footwearAndSocksOrderCheck(morningActions)) return false;
        if (shirtAndHeadwearOrderCheck(morningActions)) return false;
        if (shirtAndJacketOrderCheck(morningActions)) return false;
        if (pantsAndFootwearOrderCheck(morningActions)) return false;

        return true;
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person person) {
        if (!validate(person)) {
            List<MorningActions> morningActions = person.getMyMorningActions();

            if (footwearAndSocksOrderCheck(morningActions))
                return morningActions.indexOf(MorningActions.PUT_ON_FOOTWEAR);
            if (shirtAndHeadwearOrderCheck(morningActions))
                return morningActions.indexOf(MorningActions.PUT_ON_HEAD_WEAR);
            if (shirtAndJacketOrderCheck(morningActions))
                return morningActions.indexOf(MorningActions.PUT_ON_JACKET);
            if (pantsAndFootwearOrderCheck(morningActions))
                return morningActions.indexOf(MorningActions.PUT_ON_FOOTWEAR);
        }

        return person.getMyMorningActions().size();
    }

    private boolean footwearAndSocksOrderCheck(List<MorningActions> morningActions) {
        if (morningActions.contains(MorningActions.PUT_ON_FOOTWEAR) && morningActions.contains(MorningActions.PUT_ON_SOCKS)) {
            if (morningActions.indexOf(MorningActions.PUT_ON_SOCKS) > morningActions.indexOf(MorningActions.PUT_ON_FOOTWEAR))
                return true;
        }
        return false;
    }

    private boolean shirtAndHeadwearOrderCheck(List<MorningActions> morningActions) {
        if (morningActions.contains(MorningActions.PUT_ON_SHIRT) && morningActions.contains(MorningActions.PUT_ON_HEAD_WEAR)) {
            if (morningActions.indexOf(MorningActions.PUT_ON_SHIRT) > morningActions.indexOf(MorningActions.PUT_ON_HEAD_WEAR))
                return true;

        }
        return false;
    }

    private boolean shirtAndJacketOrderCheck(List<MorningActions> morningActions) {
        if (morningActions.contains(MorningActions.PUT_ON_SHIRT) && morningActions.contains(MorningActions.PUT_ON_JACKET)) {
            if (morningActions.indexOf(MorningActions.PUT_ON_SHIRT) > morningActions.indexOf(MorningActions.PUT_ON_JACKET))
                return true;
        }
        return false;
    }

    private boolean pantsAndFootwearOrderCheck(List<MorningActions> morningActions) {
        if (morningActions.contains(MorningActions.PUT_ON_PANTS) && morningActions.contains(MorningActions.PUT_ON_FOOTWEAR)) {
            if (morningActions.indexOf(MorningActions.PUT_ON_PANTS) > morningActions.indexOf(MorningActions.PUT_ON_FOOTWEAR))
                return true;
        }
        return false;
    }

    @Override
    public boolean validate(Person person) {
        return areActionsInTheCorrectOrder(person);
    }
}
