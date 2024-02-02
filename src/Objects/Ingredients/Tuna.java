package Objects.Ingredients;



import Objects.Ingredient;

public class Tuna implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Tuna \uD83D\uDC1F");
        return new Tuna();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Tuna \uD83D\uDC1F");
        return i;
    }

    @Override
    public String getName() {
        return "Tuna \uD83D\uDC1F";
    }
}
