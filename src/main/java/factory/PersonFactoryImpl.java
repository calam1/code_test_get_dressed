package factory;

import commands.MorningActions;
import commands.Temperature;
import commands.Validation;
import domains.Person;

public class PersonFactoryImpl implements PersonFactory {

    private ValidationFactory<Person> personValidationFactory;
    private Mapper<Person> personMapper;
    private TemperatureProcessor temperatureProcessor;

    public PersonFactoryImpl(ValidationFactory<Person> personValidationFactory, Mapper<Person> personMapper,
                             TemperatureProcessor temperatureProcessor) {
        this.personValidationFactory = personValidationFactory;
        this.personMapper = personMapper;
        this.temperatureProcessor = temperatureProcessor;
    }

    @Override
    public Person createPerson(String[] values) {
        if (values == null || values.length == 0) throw new RuntimeException("you passed in no arguments, please provide arguments");

        Temperature temperature = temperatureProcessor.mapTemperature(values[0]);
        Validation<Person> morningPreparationValidation = personValidationFactory.createValidations();
        Person person = new Person(temperature, morningPreparationValidation);
        personMapper.mapPassedInValuesToActions(values, person);

        return person;
    }
}
