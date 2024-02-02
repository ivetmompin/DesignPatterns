package Objects.Ingredients;


import Objects.Ingredient;

public class Cheddar implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Cheddar \uD83E\uDDC0");
        return new Cheddar();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Cheddar \uD83E\uDDC0");
        return i;
    }

    @Override
    public String getName() {
        return "Cheddar \uD83E\uDDC0";
    }
}
