package validators;

import commands.ClothingActions;
import commands.Person;
import commands.Temperature;
import org.junit.Before;
import org.junit.Test;
import validators.impl.ValidClothesForHotTemperature;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidClothesForHotTemperatureTest {

    private ValidClothesForTemperature<Person> validClothesForTemperature;

    @Before
    public void setup(){
        validClothesForTemperature = new ValidClothesForHotTemperature();
    }

    @Test
    public void it_Is_Hot_Outside_You_Cannot_Wear_Socks(){
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.SOCKS);

        boolean areClothesValid = validClothesForTemperature.validClothesForWeather(person);

        assertFalse(areClothesValid);
    }

    @Test
    public void it_Is_Cold_Outside_You_Can_Wear_Socks(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.SOCKS);

        boolean areClothesValid = validClothesForTemperature.validClothesForWeather(person);

        assertTrue(areClothesValid);
    }

    @Test
    public void it_Is_Hot_Outside_You_Cannot_Wear_A_Jacket(){
        Person person = new Person(Temperature.HOT);

        person.addClothingActions(ClothingActions.JACKET);

        boolean areClothesValid =  validClothesForTemperature.validClothesForWeather(person);

        assertFalse(areClothesValid);
    }

    @Test
    public void it_Is_Cold_Outside_You_Can_Wear_A_Jacket(){
        Person person = new Person(Temperature.COLD);

        person.addClothingActions(ClothingActions.JACKET);

        boolean areClothesValid = validClothesForTemperature.validClothesForWeather(person);

        assertTrue(areClothesValid);
    }

}
