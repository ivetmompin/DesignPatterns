package Objects.Ingredients;

import Objects.Ingredient;

public class Artichoke implements Ingredient {

    @Override
    public Ingredient add() {
        System.out.println("Adding Artichoke \uD83E\uDD6C");
        return new Artichoke();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Artichoke \uD83E\uDD6C");
        return i;
    }

    @Override
    public String getName() {
        return "Artichoke \uD83E\uDD6C";
    }

}
