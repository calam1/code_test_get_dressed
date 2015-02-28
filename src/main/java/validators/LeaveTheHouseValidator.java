package validators;

public interface LeaveTheHouseValidator<T> {
    boolean canILeaveTheHouse(T domain);
}
