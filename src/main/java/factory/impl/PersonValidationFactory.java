package factory.impl;

import commands.MorningPreparationValidation;
import commands.Validation;
import domains.Person;
import factory.ValidationFactory;
import validators.ValidationElement;
import validators.impl.ClothesForHotTemperatureValidator;
import validators.impl.ClothingActionOrdersValidator;
import validators.impl.DuplicateClothesForPersonValidator;
import validators.impl.LeaveTheHouseFullyClothedValidator;
import validators.impl.PersonPajamaValidator;

import java.util.ArrayList;
import java.util.List;

public class PersonValidationFactory implements ValidationFactory<Person> {
    @Override
    public Validation<Person> createValidations() {
        Validation<Person> morningPreparationValidation;

        morningPreparationValidation = new MorningPreparationValidation();

        List<ValidationElement<Person>> validationElements = new ArrayList<>();
        validationElements.add(new PersonPajamaValidator());
        validationElements.add(new DuplicateClothesForPersonValidator());
        validationElements.add(new ClothesForHotTemperatureValidator());
        validationElements.add(new ClothingActionOrdersValidator());
        validationElements.add(new LeaveTheHouseFullyClothedValidator());

        morningPreparationValidation.setValidationRules(validationElements);

        return morningPreparationValidation;
    }
}
