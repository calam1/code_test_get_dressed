package factory.impl;

import commands.Temperature;
import commands.Validation;
import domains.Person;
import factory.PersonFactory;
import factory.ValidationFactory;
import helpers.Mapper;
import helpers.TemperatureProcessor;

import java.util.Arrays;

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
        String [] actions = Arrays.copyOfRange(values, 1, values.length);//exclude the temperature
        personMapper.mapPassedInValuesToActions(actions, person);

        return person;
    }
}
