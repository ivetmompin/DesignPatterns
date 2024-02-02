package Objects.Ingredients;

import Objects.Ingredient;

public class Bacon implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Bacon \uD83E\uDD53");
        return new Bacon();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Bacon \uD83E\uDD53");
        return i;
    }

    @Override
    public String getName() {
        return "Bacon \uD83E\uDD53";
    }

}
