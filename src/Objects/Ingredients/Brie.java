package Objects.Ingredients;



import Objects.Ingredient;

public class Brie implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Brie \uD83E\uDDC0");
        return new Brie();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Brie \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Brie \uD83E\uDDC0";
    }
}
