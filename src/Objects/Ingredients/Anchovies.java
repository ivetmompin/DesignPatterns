package Objects.Ingredients;

import Objects.Ingredient;

public class Anchovies implements Ingredient{
        @Override
        public Ingredient add() {
            System.out.println("Adding Anchovies \uD83D\uDC1F");
            return new Objects.Ingredients.Artichoke();
        }

    @Override
    public int remove(int i) {
        System.out.println("Removing Anchovies \uD83D\uDC1F");
        return i;
    }

    @Override
        public String getName() {
            return "Anchovies  \uD83D\uDC1F";
        }
}
