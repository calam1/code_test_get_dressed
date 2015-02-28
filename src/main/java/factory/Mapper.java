package factory;

public interface Mapper<T> {
    void mapPassedInValuesToActions(String [] values, T domain);
}
