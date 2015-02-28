package commands;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private Temperature temperature;
    private List<ClothingActions> myClothes = new ArrayList<>();

    public Person(Temperature temperature) {
        this.temperature = temperature;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public List<ClothingActions> getMyClothes() {
        return myClothes;//TODO defensive copy this
    }

    public void addClothingActions(ClothingActions clothes) {
        myClothes.add(clothes);
    }

}
