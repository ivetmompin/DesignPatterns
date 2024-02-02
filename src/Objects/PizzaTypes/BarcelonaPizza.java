package Objects.PizzaTypes;
import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;


import java.util.ArrayList;
import java.util.List;

public class BarcelonaPizza implements Pizza {

    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public BarcelonaPizza(Crust crust){
        System.out.print("""
                
                -------------Barcelona Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Onion onion = new Onion();
        ingredients.add(onion.add());
        Beef beef = new Beef();
        ingredients.add(beef.add());
        Brie brie = new Brie();
        ingredients.add(brie.add());
        Ham ham = new Ham();
        ingredients.add(ham.add());
        Olives olives = new Olives();
        ingredients.add(olives.add());
        updateQuantities();
    }

    @Override
    public void prepare() {
        System.out.println("\nPreparing Barcelona Pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Barcelona Pizza");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Barcelona Pizza");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Barcelona Pizza");
    }

    @Override
    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @Override
    public Crust getCrust() {
        return this.crust;
    }

    @Override
    public void updateQuantities() {
        Utilities utilities = new Utilities();
        System.out.println("Updating quantities for Barcelona pizza...");
        ArrayList<Boolean> marking = new ArrayList<>();
        marking = utilities.initMarking(marking,ingredients.size());
        for(Ingredient ingredient: this.ingredients){
            if(!marking.get(ingredients.indexOf(ingredient))) {
                quantities.add(utilities.countIngredientsOfTheClass(ingredients, ingredient, marking));
            }
        }
    }

    @Override
    public List<Integer> getQuantities() {
        return this.quantities;
    }

    public int getType() {
        return 3;
    }

    @Override
    public String getName() {
        return "Barcelona";
    }
}
