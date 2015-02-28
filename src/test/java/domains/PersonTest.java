package domains;

import commands.MorningActions;
import commands.Temperature;
import commands.Validation;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PersonTest extends TestCase {

    @Mock
    private Validation<Person> personValidation;

    @Test
    public void result_Of_My_Morning_Preparedness_Should_Be_False() {
        Person person = new Person(Temperature.HOT, personValidation);

        person.addMorningActions(MorningActions.TAKE_OFF_PAJAMAS);
        person.addMorningActions(MorningActions.PUT_ON_JACKET);

        when(personValidation.validate(person)).thenReturn(false);
        boolean actual = person.resultOfMyMorningPreparedness();

        assertFalse(actual);
        verify(personValidation, times(1)).validate(person);
    }
}