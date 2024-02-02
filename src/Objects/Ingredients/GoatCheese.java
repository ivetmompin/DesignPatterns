package Objects.Ingredients;



import Objects.Ingredient;

public class GoatCheese implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Goat Cheese \uD83E\uDDC0");
        return new GoatCheese();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Goat Cheese \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Goat \uD83E\uDDC0";
    }
}
