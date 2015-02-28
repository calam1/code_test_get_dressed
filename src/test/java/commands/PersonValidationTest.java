package commands;

import org.junit.Before;
import org.junit.Test;
import validators.ValidationElement;
import validators.impl.ClothingActionOrders;
import validators.impl.DuplicateClothesForPersonValidator;
import validators.impl.LeaveTheHouseFullyClothedValidator;
import validators.impl.PajamaValidatorForPerson;
import validators.impl.ValidClothesForHotTemperature;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonValidationTest {

    List<ValidationElement<Person>> validationElements;
    PersonValidation personValidation;

    @Before
    public void setup() {
        personValidation = new PersonValidation();

        validationElements = new ArrayList<>();
        validationElements.add(new PajamaValidatorForPerson());
        validationElements.add(new DuplicateClothesForPersonValidator());
        validationElements.add(new ValidClothesForHotTemperature());
        validationElements.add(new ClothingActionOrders());
        validationElements.add(new LeaveTheHouseFullyClothedValidator());

        personValidation.setValidationRules(validationElements);
    }

    @Test
    public void did_Not_Take_Off_Pajamas_Is_Invalid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.HEADWEAR);

        boolean isValid = personValidation.validate(person);
        assertFalse(isValid);
    }

    @Test
    public void put_Everything_On_Correctly_Is_Valid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.PANTS);
        person.addClothingActions(ClothingActions.SOCKS);
        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.HEADWEAR);
        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        boolean isValid = personValidation.validate(person);
        assertTrue(isValid);
    }

    @Test
    public void wore_Jacket_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.SOCKS);

        int problemIndex = personValidation.findInvalidIndexValue(person);
        assertEquals(2, problemIndex);
    }

    @Test
    public void wore_Jacket_And_Socks_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.SOCKS);

        int problemIndex = personValidation.findInvalidIndexValue(person);
        assertEquals(1, problemIndex);
    }
}
