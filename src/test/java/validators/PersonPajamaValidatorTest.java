package validators;

import commands.MorningActions;
import domains.Person;
import commands.Temperature;
import commands.Validation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import validators.impl.PersonPajamaValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersonPajamaValidatorTest {

    private PajamaValidator<Person> pajamaValidator;

    @Mock
    private Validation<Person> personValidation;

    @Before
    public void setup() {
        pajamaValidator = new PersonPajamaValidator();
    }

    @Test
    public void pajamas_Are_Still_On_As_I_Get_Dressed_Is_Invalid() {
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.PUT_ON_SHIRT);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertFalse(doIlookFine);
    }

    @Test
    public void pajamas_Are_Off_As_I_Get_Dressed_Is_Valid() {
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_SHIRT);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }

    @Test
    public void pajamas_Are_On_And_I_Do_Nothing_Else_Is_Valid() {
        Person person = new Person(Temperature.COLD, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);

        boolean doIlookFine = pajamaValidator.arePajamasOff(person);
        assertTrue(doIlookFine);
    }

}