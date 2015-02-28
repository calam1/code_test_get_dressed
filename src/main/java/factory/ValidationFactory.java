package factory;

import commands.Validation;

public interface ValidationFactory<T> {
   Validation<T> createValidations();
}
