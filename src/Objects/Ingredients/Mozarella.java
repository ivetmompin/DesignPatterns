package Objects.Ingredients;



import Objects.Ingredient;

public class Mozarella implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Mozarella \uD83E\uDDC0");
        return new Mozarella();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Mozarella \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Mozarella \uD83E\uDDC0";
    }
}
