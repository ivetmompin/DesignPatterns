package Objects.Ingredients;



import Objects.Ingredient;

public class Frankfurt implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Frankfurt \uD83C\uDF2D");
        return new Frankfurt();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Frankfurt \uD83C\uDF2D");
        return i;
    }

    @Override
    public String getName() {
        return "Frankfurt \uD83C\uDF2D";
    }
}
