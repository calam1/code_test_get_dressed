package validators.impl;

import commands.ClothingActions;
import commands.Person;
import validators.PajamaValidator;
import validators.ValidationElement;

import java.util.List;

public class PersonPajamaValidator implements PajamaValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean arePajamasOff(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();
        if (myClothes.get(0) != ClothingActions.TAKE_OFF_PAJAMAS) return false;
        return true;
    }

    @Override
    public boolean validate(Person person) {
        return arePajamasOff(person);
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person domain) {
        return 0;
    }
}
