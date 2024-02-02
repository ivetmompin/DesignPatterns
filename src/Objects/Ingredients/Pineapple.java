package Objects.Ingredients;



import Objects.Ingredient;

public class Pineapple implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Pineapple \uD83C\uDF4D");
        return new Pineapple();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Pineapple \uD83C\uDF4D");
        return i;
    }

    @Override
    public String getName() {
        return "Pineapple \uD83C\uDF4D";
    }
}
