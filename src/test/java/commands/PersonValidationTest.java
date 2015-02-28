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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonValidationTest {

    List<ValidationElement<Person>> validationElements;
    PersonValidation personValidation;

    @Before
    public void setup() {
        personValidation = new PersonValidationImpl();

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

        boolean isValid = personValidation.validatePerson(person);
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

        boolean isValid = personValidation.validatePerson(person);
        assertTrue(isValid);
    }


}
