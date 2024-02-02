package Objects.Drinks;

import Objects.Drink;

public class Water implements Drink {
    @Override
    public void grabFromShelve() {
        System.out.println("Grabbing water from shelve");
    }
    public String name(){ return "Water"; }
}
