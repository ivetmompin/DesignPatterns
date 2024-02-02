package Objects.Ingredients;



import Objects.Ingredient;
public class Sobrasada implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Sobrasada \uD83D\uDC16");
        return new Sobrasada();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Sobrasada \uD83D\uDC16");
        return i;
    }

    @Override
    public String getName() {
        return "Sobrassada \uD83D\uDC16";
    }
}
