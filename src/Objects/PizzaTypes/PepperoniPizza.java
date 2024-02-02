package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class PepperoniPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients;
    private List<Integer> quantities;

    public PepperoniPizza(Crust crust) {
        System.out.print("""
                
                -------------Pepperoni Pizza Configuration-------------
                
                """);
        this.ingredients = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.crust=crust;
        Pepperoni pepperoni = new Pepperoni();
        ingredients.add(pepperoni.add());
        Ham ham = new Ham();
        ingredients.add(ham.add());
        Beef beef = new Beef();
        ingredients.add(beef.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Pepperoni pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Pepperoni pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Pepperoni pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Pepperoni pizza...");
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
        System.out.println("Updating quantities for Pepperoni pizza...");
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
        return 18;
    }

    @Override
    public String getName() {
        return "Pepperoni";
    }
}