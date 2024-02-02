package Objects.Ingredients;



import Objects.Ingredient;

public class Sausage implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Sausage \uD83C\uDF2D");
        return new Sausage();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Sausage \uD83C\uDF2D");
        return i;
    }

    @Override
    public String getName() {
        return "Sausages \uD83C\uDF2D";
    }
}
