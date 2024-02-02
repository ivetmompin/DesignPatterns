package Objects.Drinks;

import Objects.Drink;

public class Soda implements Drink {
    @Override
    public void grabFromShelve() {
        System.out.println("Grabbing soda from shelve");
    }
    public String name(){ return "Soda"; }
}
