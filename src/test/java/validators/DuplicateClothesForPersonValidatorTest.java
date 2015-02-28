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

        person.addClothingActions(ClothingActions.FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);

        assertFalse(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_Is_Invalid() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_And_Jacket_Once_Is_Invalid(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.FOOTWEAR);
        person.addClothingActions(ClothingActions.JACKET);
        person.addClothingActions(ClothingActions.FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

}
