package commands;

import validators.ValidationElement;

import java.util.List;

public class PersonValidationImpl implements PersonValidation {
    private List<ValidationElement<Person>> validationElements;

    @Override
    public boolean validatePerson(Person person) {
        for (ValidationElement<Person> validationElement : validationElements) {
            boolean valid = validationElement.validate(person);
            if (!valid){
                return false;
            }
        }

        return true;
    }

    @Override
    public void setValidationRules(List<ValidationElement<Person>> validationElements) {
        this.validationElements = validationElements;
    }
}
