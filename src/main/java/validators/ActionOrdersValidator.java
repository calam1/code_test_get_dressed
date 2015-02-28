package validators;

public interface ActionOrdersValidator<T> {
    boolean areActionsInTheCorrectOrder(T domain);
}
