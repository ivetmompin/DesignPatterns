package Objects.Ingredients;



import Objects.Ingredient;

public class Tomato implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Tomato Slices \uD83C\uDF45");
        return new Tomato();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Tomato Slices \uD83C\uDF45");
        return i;
    }

    @Override
    public String getName() {
        return "Tomato \uD83C\uDF45";
    }
}
