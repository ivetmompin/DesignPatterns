package Objects.Ingredients;



import Objects.Ingredient;

public class Pepperoni implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Peperoni \uD83C\uDF55");
        return new Pepperoni();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Peperoni \uD83C\uDF55");
        return i;
    }

    @Override
    public String getName() {
        return "Pepperoni \uD83C\uDF55";
    }
}
