package Objects.Ingredients;



import Objects.Ingredient;

public class Olives implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Olives \uD83E\uDED2");
        return new Olives();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Olives \uD83E\uDED2");
        return i;
    }

    @Override
    public String getName() {
        return "Olives \uD83E\uDED2";
    }
}
