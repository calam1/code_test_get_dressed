package validators;


import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.DuplicateClothesForPersonValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DuplicateClothesForPersonValidatorTest {

    private DuplicateItemsValidator<Person> duplicateItemsValidator;

    @Before
    public void setup() {
        duplicateItemsValidator = new DuplicateClothesForPersonValidator();
    }

    @Test
    public void only_One_Item_May_Be_Put_On() {
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);

        assertFalse(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_Is_Invalid() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_And_Jacket_Once_Is_Invalid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.TAKE_OFF_PAJAMAS);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);
        person.addClothingActions(ClothingActions.PUT_ON_JACKET);
        person.addClothingActions(ClothingActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

}
