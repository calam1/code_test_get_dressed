package commands;

import validators.ValidationElement;

import java.util.List;

public interface Validation<T> {
    boolean validate(T domain);
    int findInvalidIndexValue(Person person);
    void setValidationRules(List<ValidationElement<Person>> validationElements);
}
