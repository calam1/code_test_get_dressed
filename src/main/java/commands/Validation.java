package commands;

import validators.ValidationElement;

import java.util.List;

public interface Validation<T> {
    void setValidationRules(List<ValidationElement<T>> validationElements);
    boolean validate(T domain);
    int findInvalidIndexValueIfItExists(T domain);
}
