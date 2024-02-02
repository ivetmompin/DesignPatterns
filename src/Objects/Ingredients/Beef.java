package Objects.Ingredients;



import Objects.Ingredient;

public class Beef implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Beef \uD83E\uDD69");
        return new Beef();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Beef \uD83E\uDD69");
        return i;
    }

    @Override
    public String getName() {
        return "Beef \uD83E\uDD69";
    }
}
