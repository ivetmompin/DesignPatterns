package Objects.Ingredients;



import Objects.Ingredient;

public class Prawn implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Prawn \uD83C\uDF64");
        return new Prawn();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Prawn \uD83C\uDF64");
        return i;
    }

    @Override
    public String getName() {
        return "Prawns \uD83C\uDF64";
    }
}
