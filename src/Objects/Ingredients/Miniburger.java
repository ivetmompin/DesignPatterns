package Objects.Ingredients;



import Objects.Ingredient;

public class Miniburger implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Miniburger \uD83C\uDF54");
        return new Miniburger();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Miniburger \uD83C\uDF54");
        return i;
    }

    @Override
    public String getName() {
        return "Miniburger \uD83C\uDF54";
    }
}
