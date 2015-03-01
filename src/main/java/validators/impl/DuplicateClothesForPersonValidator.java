package validators.impl;

import commands.MorningActions;
import domains.Person;
import validators.DuplicateItemsValidator;
import validators.ValidationElement;

import java.util.List;

public class DuplicateClothesForPersonValidator implements DuplicateItemsValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean hasDuplicateItems(Person person) {
        List<MorningActions> morningActions = person.getMyMorningActions();

        for (MorningActions clothes : morningActions) {
            int counter = 0;
            for (MorningActions clothesItem : morningActions) {
                if (clothes == clothesItem)
                    counter++;
            }
            if (counter > 1) return true;
        }

        return false;
    }

    @Override
    public boolean validate(Person person) {
        if (hasDuplicateItems(person)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int findInvalidItemIndexOrReturnCollectionSizeIfValid(Person person) {
        if (!validate(person)){
            List<MorningActions> morningActions = person.getMyMorningActions();

            for (MorningActions clothes : morningActions) {
                int counter = 0;
                for (MorningActions clothesItem : morningActions) {
                    if (clothes == clothesItem)
                        counter++;
                }
                if (counter > 1) return morningActions.lastIndexOf(clothes);
            }
        }

        return person.getMyMorningActions().size();
    }
}
