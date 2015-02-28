package validators;

public interface ActionOrders<T> {
    boolean areActionsInTheCorrectOrder(T domain);
}
