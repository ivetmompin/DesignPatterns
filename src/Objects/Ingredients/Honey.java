package Objects.Ingredients;



import Objects.Ingredient;

public class Honey implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Honey \uD83C\uDF6F");
        return new Honey();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Honey \uD83C\uDF6F");
        return i;
    }

    @Override
    public String getName() {
        return "Honey \uD83C\uDF6F";
    }
}
