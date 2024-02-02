package Objects.Ingredients;



import Objects.Ingredient;

public class BellPepper implements Ingredient {

    public Ingredient add() {
        System.out.println("Adding Bell Pepper \uD83C\uDF36\uFE0F");
        return new BellPepper();
    }

    @Override
    public int remove(int i) {
        System.out.println("Removing Bell Pepper \uD83C\uDF36\uFE0F");
        return i;
    }

    @Override
    public String getName() {
        return "Bell Pepper \uD83C\uDF36\uFE0F";
    }
}
