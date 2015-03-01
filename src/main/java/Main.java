import domains.Person;
import factory.PersonFactory;
import factory.ValidationFactory;
import factory.impl.PersonFactoryImpl;
import factory.impl.PersonValidationFactory;
import helpers.Mapper;
import helpers.TemperatureProcessor;
import helpers.impl.MorningActionsForPersonMapper;
import helpers.impl.TemperatureProcessorImpl;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Pass in space separated values i.e. HOT 3 5 6");
        }

        PersonFactory personFactory = createPersonFactory();
        Person person = personFactory.createPerson(args);
        String results = person.resultOfMyMorningPreparedness();
        System.out.println(results);
    }

    private static PersonFactory createPersonFactory() {
        ValidationFactory<Person> personValidationFactory = new PersonValidationFactory();
        Mapper<Person> personMapper = new MorningActionsForPersonMapper();
        TemperatureProcessor temperatureProcessor = new TemperatureProcessorImpl();

        PersonFactory personFactory = new PersonFactoryImpl(personValidationFactory, personMapper, temperatureProcessor);
        return personFactory;
    }
}
