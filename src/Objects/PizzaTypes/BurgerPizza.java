package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class BurgerPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public BurgerPizza(Crust crust){
        System.out.print("""
                
                -------------Burger Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Miniburger miniburger = new Miniburger();
        ingredients.add(miniburger.add());
        Egg egg = new Egg();
        ingredients.add(egg.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        Onion onion = new Onion();
        ingredients.add(onion.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Burger pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Burger pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Burger pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Burger pizza...");
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
        System.out.println("Updating quantities for Burger pizza...");
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
        return 5;
    }

    @Override
    public String getName() {
        return "Burger";
    }
}
