package validators;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.LeaveTheHouseFullyClothedValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeaveTheHouseFullyClothedValidatorTest {

    private LeaveTheHouseValidator<Person> leaveTheHouseValidator;

    @Before
    public void setup() {
        leaveTheHouseValidator = new LeaveTheHouseFullyClothedValidator();
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Cold_Before_I_Am_Fully_Dressed_Is_Invalid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertFalse(canILeaveTheHouse);
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Cold_And_I_Am_Fully_Dressed_Is_Valid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.SOCKS);
        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.HEADWEAR);
        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.PANTS);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertTrue(canILeaveTheHouse);
    }

    @Test
    public void trying_To_Leave_House_When_It_Is_Hot_And_I_Am_Fully_Dressed_Is_Valid(){
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.HEADWEAR);
        person.addClothingActions(ClothingActions.PANTS);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        boolean canILeaveTheHouse = leaveTheHouseValidator.canILeaveTheHouse(person);

        assertTrue(canILeaveTheHouse);
    }
}
