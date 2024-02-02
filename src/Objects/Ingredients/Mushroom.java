package Objects.Ingredients;



import Objects.Ingredient;

public class Mushroom implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Mushrooms \uD83C\uDF44");
        return new Mushroom();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Mushrooms \uD83C\uDF44");
        return i;
    }

    @Override
    public String getName() {
        return "Mushrooms \uD83C\uDF44";
    }
}
