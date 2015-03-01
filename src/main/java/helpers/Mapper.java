package helpers;

public interface Mapper<T> {
    void mapPassedInValuesToActions(String [] values, T domain);
}
