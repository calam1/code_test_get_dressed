package validators;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.ClothingActionOrdersValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClothingActionsActionOrdersValidatorTest {

    private ActionOrdersValidator<Person> actionOrdersValidator;

    @Before
    public void setup() {
        actionOrdersValidator = new ClothingActionOrdersValidator();
    }

    @Test
    public void put_Footwear_On_Before_Socks_Is_Not_Allowed() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Socks_On_Before_Footwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_SOCKS);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_HeadWear_On_Before_Shirt_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);
        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Shirt_On_Before_Headwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);
        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_Jacket_On_Before_Shirt_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Shirt_On_Before_Jacket_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);
        person.addClothingActions(ClothingActions.PUT_ON_JACKET);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_Jacket_And_Shirt_On_Before_Headwear_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_SHIRT);
        person.addClothingActions(ClothingActions.PUT_ON_HEAD_WEAR);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Footwear_On_Before_Pants_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_PANTS);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Pants_On_Before_Footwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PUT_ON_PANTS);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);

        boolean areClothesActionInOrder = actionOrdersValidator.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

}
