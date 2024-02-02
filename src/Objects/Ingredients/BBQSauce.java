package Objects.Ingredients;

import Objects.Ingredient;

public class BBQSauce implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding BBQ Sauce \uD83D\uDD25");
        return new BBQSauce();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing BBQ Sauce \uD83D\uDD25");
        return i;
    }

    @Override
    public String getName() {
        return "BBQ Sauce \uD83D\uDD25";
    }
}
