package factory;

import domains.Person;

public interface PersonFactory {
    Person createPerson(String [] values);
}
