package validators;

public interface ValidationElement<T> {
    boolean validate(T domain);
}
