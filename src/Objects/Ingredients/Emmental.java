package Objects.Ingredients;



import Objects.Ingredient;

public class Emmental implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Emmental \uD83E\uDDC0");
        return new Emmental();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Emmental \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Emmental \uD83E\uDDC0";
    }
}
