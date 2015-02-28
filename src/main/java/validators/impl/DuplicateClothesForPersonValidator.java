package validators.impl;

import commands.ClothingActions;
import commands.Person;
import validators.DuplicateItemsValidator;
import validators.ValidationElement;

import java.util.List;

public class DuplicateClothesForPersonValidator implements DuplicateItemsValidator<Person>, ValidationElement<Person> {
    @Override
    public boolean hasDuplicateItems(Person person) {
        List<ClothingActions> myClothes = person.getMyClothes();

        for (ClothingActions clothes : myClothes) {
            int counter = 0;
            for (ClothingActions clothesItem : myClothes) {//TODO: replace with indexOf and lastIndexOf
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
    public int findIndexOfCollectionForValidationFailure(Person domain) {
        return 0;
    }
}
