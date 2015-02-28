package validators;

public interface FailedIndex<T> {
    int findIndexOfCollectionForValidationFailure(T domain);
}
