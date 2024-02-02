package Objects.Ingredients;



import Objects.Ingredient;

public class CarbonaraSauce implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Carbonara sauce \uD83E\uDED5");
        return new CarbonaraSauce();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Carbonara sauce \uD83E\uDED5");
        return i;
    }

    @Override
    public String getName() {
        return "Carbonara Sauce \uD83E\uDED5";
    }
}
