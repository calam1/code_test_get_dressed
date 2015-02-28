package commands;

import validators.ValidationElement;

import java.util.List;

public interface PersonValidation {
    boolean validatePerson(Person person);

    void setValidationRules(List<ValidationElement<Person>> validationElements);
}
