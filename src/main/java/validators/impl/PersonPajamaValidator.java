package validators.impl;

import commands.MorningActions;
import domains.Person;
import validators.PajamaValidator;
import validators.ValidationElement;

import java.util.List;

public class PersonPajamaValidator implements PajamaValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean arePajamasOff(Person person) {
        List<MorningActions> morningActions = person.getMyMorningActions();
        if (morningActions.get(0) != MorningActions.TAKE_OFF_PAJAMAS) return false;
        return true;
    }

    @Override
    public boolean validate(Person person) {
        return arePajamasOff(person);
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person person) {
        if (!validate(person)) {
            List<MorningActions> morningActions = person.getMyMorningActions();
            if (morningActions.get(0) != MorningActions.TAKE_OFF_PAJAMAS)
                return morningActions.indexOf(MorningActions.TAKE_OFF_PAJAMAS);
        }

        return person.getMyMorningActions().size();
    }
}
