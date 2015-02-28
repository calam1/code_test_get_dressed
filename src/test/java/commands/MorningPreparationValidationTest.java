package commands;

import domains.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
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

@RunWith(MockitoJUnitRunner.class)
public class MorningPreparationValidationTest {

    private List<ValidationElement<Person>> validationElements;
    private Validation morningPreparationValidation;

    @Mock
    Validation<Person> validation;

    @Before
    public void setup() {
        morningPreparationValidation = new MorningPreparationValidation();

        validationElements = new ArrayList<>();
        validationElements.add(new PersonPajamaValidator());
        validationElements.add(new DuplicateClothesForPersonValidator());
        validationElements.add(new ClothesForHotTemperatureValidator());
        validationElements.add(new ClothingActionOrdersValidator());
        validationElements.add(new LeaveTheHouseFullyClothedValidator());

        morningPreparationValidation.setValidationRules(validationElements);
    }

    @Test
    public void did_Not_Take_Off_Pajamas_Is_Invalid(){
        Person person = new Person(Temperature.COLD, validation);

        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_HEAD_WEAR);

        boolean isValid = morningPreparationValidation.validate(person);
        assertFalse(isValid);
    }

    @Test
    public void put_Everything_On_Correctly_Is_Valid(){
        Person person = new Person(Temperature.COLD, validation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_PANTS);
        person.addMorningActions(MorningActions.PUT_ON_SOCKS);
        person.addMorningActions(MorningActions.PUT_ON_SHIRT);
        person.addMorningActions(MorningActions.PUT_ON_HEAD_WEAR);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.LEAVE_HOUSE);

        boolean isValid = morningPreparationValidation.validate(person);
        assertTrue(isValid);
    }

    @Test
    public void wore_Jacket_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT, validation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_SOCKS);

        int problemIndex = morningPreparationValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(2, problemIndex);
    }

    @Test
    public void wore_Jacket_And_Socks_On_Hot_Day_Is_Invalid_Return_Index_Value_Of_First_Sight_Of_Problem() {
        Person person = new Person(Temperature.HOT, validation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_SOCKS);

        int problemIndex = morningPreparationValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(1, problemIndex);
    }

    @Test
    public void put_Everything_On_Correctly_Return_List_Size_For_Cold(){
        Person person = new Person(Temperature.COLD, validation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_PANTS);
        person.addMorningActions(MorningActions.PUT_ON_SOCKS);
        person.addMorningActions(MorningActions.PUT_ON_SHIRT);
        person.addMorningActions(MorningActions.PUT_ON_HEAD_WEAR);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.LEAVE_HOUSE);

        int index = morningPreparationValidation.findInvalidIndexValueIfItExists(person);
        assertEquals(8, index);
    }

}
