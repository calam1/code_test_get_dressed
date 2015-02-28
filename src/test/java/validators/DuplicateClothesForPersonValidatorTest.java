package validators;


import commands.MorningActions;
import domains.Person;
import commands.Temperature;
import commands.Validation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import validators.impl.DuplicateClothesForPersonValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DuplicateClothesForPersonValidatorTest {

    private DuplicateItemsValidator<Person> duplicateItemsValidator;

    @Mock
    private Validation<Person> personValidation;

    @Before
    public void setup() {
        duplicateItemsValidator = new DuplicateClothesForPersonValidator();
    }

    @Test
    public void only_One_Item_May_Be_Put_On() {
        Person person = new Person(Temperature.HOT, personValidation);

        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);

        assertFalse(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_Is_Invalid() {
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

    @Test
    public void put_On_Footwear_Twice_And_Jacket_Once_Is_Invalid(){
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);
        person.addMorningActions(MorningActions.PUT_ON_FOOTWEAR);

        boolean doIHaveDuplicates = duplicateItemsValidator.hasDuplicateItems(person);
        assertTrue(doIHaveDuplicates);
    }

}
