package domains;

import commands.MorningActions;
import commands.Temperature;
import commands.Validation;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final Validation<Person> personValidation;
    private final Temperature temperature;
    private final List<MorningActions> myActionsForTheMorning = new ArrayList<>();

    public Person(Temperature temperature, Validation<Person> personValidation) {
        this.temperature = temperature;
        this.personValidation = personValidation;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public List<MorningActions> getMyMorningActions() {
        return myActionsForTheMorning;//TODO defensive copy this
    }

    public void addMorningActions(MorningActions actions) {
        myActionsForTheMorning.add(actions);
    }

    public boolean resultOfMyMorningPreparedness(){
        return personValidation.validate(this);
    }

}
