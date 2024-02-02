package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class FourCheesePizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public FourCheesePizza(Crust crust){
        System.out.print("""
                
                -------------Four Cheeses Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Mozarella mozarella= new Mozarella();
        ingredients.add(mozarella.add());
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
        System.out.println("\nPreparing Four Cheese pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Four Cheese pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Four Cheese pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Four Cheese pizza...");
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
        System.out.println("Updating quantities for Four Cheeses pizza...");
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
        return 12;
    }

    @Override
    public String getName() {
        return "Four Cheeses";
    }
}

