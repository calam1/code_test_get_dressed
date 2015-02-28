package commands;

import validators.ValidationElement;

import java.util.List;

public class PersonValidation implements Validation<Person> {
    private List<ValidationElement<Person>> validationElements;

    @Override
    public void setValidationRules(List<ValidationElement<Person>> validationElements) {
        this.validationElements = validationElements;
    }

    @Override
    public boolean validate(Person person) {
        for (ValidationElement<Person> validationElement : validationElements) {
            boolean valid = validationElement.validate(person);
            if (!valid){
                return false;
            }
        }

        return true;
    }

    @Override
    public int findInvalidIndexValueIfItExists(Person person) {
        for (ValidationElement<Person> validationElement : validationElements) {
            boolean valid = validationElement.validate(person);
            if (!valid){
                return validationElement.findInvalidItemIndexOrReturnCollectionSizeIfValid(person);
            }
        }

        return person.getMyClothes().size();
    }
}
