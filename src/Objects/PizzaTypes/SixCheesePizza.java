package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class SixCheesePizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients;
    private List<Integer> quantities;

    public SixCheesePizza(Crust crust) {
        System.out.print("""
                
                -------------Six Cheese Pizza Configuration-------------
                
                """);
        this.ingredients = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.crust = crust;
        Mozarella mozarella= new Mozarella();
        ingredients.add(mozarella.add());
        GoatCheese goatCheese = new GoatCheese();
        ingredients.add(goatCheese.add());
        Brie brie = new Brie();
        ingredients.add(brie.add());
        Emmental emmental= new Emmental();
        ingredients.add(emmental.add());
        Roquefort roquefort = new Roquefort();
        ingredients.add(roquefort.add());
        Cheddar cheddar = new Cheddar();
        ingredients.add(cheddar.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Six Cheeses pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Six Cheeses pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Six Cheeses pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Six Cheeses pizza...");
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
        System.out.println("Updating quantities for Six Cheeses pizza...");
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

    @Override
    public int getType() {
        return 19;
    }

    @Override
    public String getName() {
        return "Six Cheeses";
    }
}
