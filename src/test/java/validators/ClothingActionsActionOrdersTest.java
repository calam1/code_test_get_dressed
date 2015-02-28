package validators;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.ClothingActionOrders;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClothingActionsActionOrdersTest {

    private ActionOrders<Person> actionOrders;

    @Before
    public void setup() {
        actionOrders = new ClothingActionOrders();
    }

    @Test
    public void put_Footwear_On_Before_Socks_Is_Not_Allowed() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.SOCKS);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Socks_On_Before_Footwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.SOCKS);
        person.addClothingActions(ClothingActions.FOOTWEAR);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_HeadWear_On_Before_Shirt_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.HEADWEAR);
        person.addClothingActions(ClothingActions.SHIRT);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Shirt_On_Before_Headwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.HEADWEAR);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_Jacket_On_Before_Shirt_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.SHIRT);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Shirt_On_Before_Jacket_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.JACKET);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

    @Test
    public void put_Jacket_And_Shirt_On_Before_Headwear_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.SHIRT);
        person.addClothingActions(ClothingActions.HEADWEAR);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Footwear_On_Before_Pants_Is_Not_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.PANTS);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertFalse(areClothesActionInOrder);
    }

    @Test
    public void put_Pants_On_Before_Footwear_Is_Allowed(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PANTS);
        person.addClothingActions(ClothingActions.FOOTWEAR);

        boolean areClothesActionInOrder = actionOrders.areActionsInTheCorrectOrder(person);

        assertTrue(areClothesActionInOrder);
    }

}
