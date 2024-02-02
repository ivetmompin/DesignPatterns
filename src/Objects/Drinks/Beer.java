package Objects.Drinks;

import Objects.Drink;

public class Beer implements Drink {
    @Override
    public void grabFromShelve() {
        System.out.println("Grabbing beer from shelve");
    }
    public String name(){ return "Beer"; }
}
