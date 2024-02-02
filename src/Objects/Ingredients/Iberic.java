package Objects.Ingredients;



import Objects.Ingredient;

public class Iberic implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Iberic \uD83D\uDC16");
        return new Iberic();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Iberic \uD83D\uDC16");
        return i;
    }

    @Override
    public String getName() {
        return "Iberic \uD83D\uDC16";
    }
}
