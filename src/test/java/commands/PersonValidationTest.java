package commands;

import org.junit.Before;
import org.junit.Test;
import validators.ValidationElement;
import validators.impl.ClothesForHotTemperatureValidator;
import validators.impl.ClothingActionOrdersValidator;
import validators.impl.DuplicateClothesForPersonValidator;
import validators.impl.LeaveTheHouseFullyClothedValidator;
import validators.impl.PersonPajamaValidator;

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
        validationElements.add(new PersonPajamaValidator());
        validationElements.add(new DuplicateClothesForPersonValidator());
        validationElements.add(new ClothesForHotTemperatureValidator());
        validationElements.add(new ClothingActionOrdersValidator());
        validationElements.add(new LeaveTheHouseFullyClothedValidator());

        personValidation.setValidationRules(validationElements);
    }

    @Test
    public void did_Not_Take_Off_Pajamas_Is_Invalid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);

        boolean isValid = personValidation.validate(person);
        assertFalse(isValid);
    }

    @Test
    public void put_Everything_On_Correctly_Is_Valid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_PANTS);
        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);
        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);
        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);
        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        boolean isValid = personValidation.validate(person);
        assertTrue(isValid);
    }

    @Test
    public void wore_Jacket_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);

        int problemIndex = personValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(2, problemIndex);
    }

    @Test
    public void wore_Jacket_And_Socks_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);

        int problemIndex = personValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(1, problemIndex);
    }

    @Test
    public void put_Everything_On_Correctly_Return_List_Size_For_Cold(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_PANTS);
        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);
        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);
        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);
        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.LEAVE_HOUSE);

        int index = personValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(8, index);
    }

}
