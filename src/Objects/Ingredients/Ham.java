package Objects.Ingredients;



import Objects.Ingredient;

public class Ham implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Ham \uD83D\uDC16");
        return new Ham();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Ham \uD83D\uDC16");
        return i;
    }

    @Override
    public String getName() {
        return "Ham \uD83D\uDC16";
    }
}
