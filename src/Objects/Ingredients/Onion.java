package Objects.Ingredients;



import Objects.Ingredient;

public class Onion implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Onion \uD83E\uDDC5");
        return new Onion();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Onion \uD83E\uDDC5");
        return i;
    }

    @Override
    public String getName() {
        return "Onion \uD83E\uDDC5";
    }
}
