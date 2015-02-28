package validators;

import commands.MorningActions;
import domains.Person;
import commands.Temperature;
import commands.Validation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import validators.impl.LeaveTheHouseFullyClothedValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeaveTheHouseFullyClothedValidatorTest {

    private LeaveTheHouseValidator<Person> leaveTheHouseValidator;

    @Mock
    private Validation<Person> personValidation;

    @Before
    public void setup() {
        leaveTheHouseValidator = new LeaveTheHouseFullyClothedValidator();
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Cold_Before_I_Am_Fully_Dressed_Is_Invalid(){
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertFalse(canILeaveTheHouse);
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Cold_And_I_Am_Fully_Dressed_Is_Valid(){
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_SOCKS);
        person.addMorningActions(MorningActions.PUT_ON_SHIRT);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_HEAD_WEAR);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);
        person.addMorningActions(MorningActions.PUT_ON_PANTS);
        person.addMorningActions(MorningActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertTrue(canILeaveTheHouse);
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Hot_And_I_Am_Fully_Dressed_Is_Valid(){
        Person person = new Person(Temperature.HOT, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_SHIRT);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_HEAD_WEAR);
        person.addMorningActions(MorningActions.PUT_ON_PANTS);
        person.addMorningActions(MorningActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertTrue(canILeaveTheHouse);
    }
}
