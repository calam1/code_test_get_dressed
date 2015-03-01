package domains;

import commands.MorningActions;
import commands.Temperature;
import commands.Validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {

    private final Validation<Person> personValidation;
    private final Temperature temperature;
    private final List<MorningActions> myActionsForTheMorning = new ArrayList<>();

    private static final String FAIL = "fail";

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

    public String resultOfMyMorningPreparedness() {
        int endIndex = personValidation.findInvalidIndexValueIfItExists(this);
        return processMorningActionResults(myActionsForTheMorning, endIndex);
    }

    private String processMorningActionResults(List<MorningActions> actions, int endIndex) {
        if (endIndex < 0) return FAIL;

        List<MorningActions> values = actions.subList(0, endIndex);
        StringBuilder results = new StringBuilder();

        for (MorningActions morningActions : values) {
            results.append(morningActions.getDescription(temperature));
            results.append(" ");
        }

        if (temperature == Temperature.COLD) {
            if (values.size() < 8) {
                results.append(FAIL);
            }
        } else if (temperature == Temperature.HOT) {
            if (values.size() < 6) {
                results.append(FAIL);
            }
        }

        return results.toString();
    }

}
