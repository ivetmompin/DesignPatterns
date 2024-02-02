package Objects.Ingredients;



import Objects.Ingredient;

public class Chicken implements Ingredient {
    public Ingredient add() {
        System.out.println("Adding Chicken \uD83C\uDF57");
        return new Chicken();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Chicken \uD83C\uDF57");
        return i;
    }

    @Override
    public String getName() {
        return "Chicken \uD83C\uDF57";
    }
}
