package validators;

public interface DuplicateItemsValidator<T> {
    boolean hasDuplicateItems(T domain);
}
