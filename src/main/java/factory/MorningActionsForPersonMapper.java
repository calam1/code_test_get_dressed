package factory;

import commands.MorningActions;
import domains.Person;

public class MorningActionsForPersonMapper implements Mapper<Person> {
    @Override
    public void mapPassedInValuesToActions(String[] values, Person person) {
        for (String action : values) {
            person.addMorningActions(MorningActions.getAction(Integer.valueOf(action)));
        }
    }
}
