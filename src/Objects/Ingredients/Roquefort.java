package Objects.Ingredients;



import Objects.Ingredient;

public class Roquefort implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Roquefort \uD83E\uDDC0");
        return new Roquefort();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Roquefort \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Roquefort \uD83E\uDDC0";
    }
}
