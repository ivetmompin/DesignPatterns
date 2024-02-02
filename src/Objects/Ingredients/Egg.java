package Objects.Ingredients;



import Objects.Ingredient;

public class Egg implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Egg \uD83E\uDD5A");
        return new Egg();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Egg \uD83E\uDD5A");
        return i;
    }

    @Override
    public String getName() {
        return "Egg \uD83E\uDD5A";
    }
}
