package validators;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.PajamaValidatorForPerson;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PajamaValidatorForPersonTest {

    private PajamaValidator<Person> pajamaValidator;

    @Before
    public void setup() {
        pajamaValidator = new PajamaValidatorForPerson();
    }

    @Test
    public void pajamas_Are_Still_On_As_I_Get_Dressed_Is_Invalid() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.SHIRT);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertFalse(doIlookFine);
    }

    @Test
    public void pajamas_Are_Off_As_I_Get_Dressed_Is_Valid() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);
        person.addClothingActions(ClothingActions.SHIRT);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }

    @Test
    public void pajamas_Are_On_And_I_Do_Nothing_Else_Is_Valid() {
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.PAJAMAS);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }

}