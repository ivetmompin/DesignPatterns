package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class CowboyPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public CowboyPizza(Crust crust){
        System.out.print("""
                
                -------------Cowboy Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        BBQSauce bbqSauce= new BBQSauce();
        ingredients.add(bbqSauce.add());
        Cheddar cheddar= new Cheddar();
        ingredients.add(cheddar.add());
        Roquefort roquefort = new Roquefort();
        ingredients.add(roquefort.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Cowboy pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Cowboy pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Cowboy pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Cowboy pizza...");
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
        System.out.println("Updating quantities for Cowboy pizza...");
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
        return 10;
    }

    @Override
    public String getName() {
        return "Cowboy";
    }
}

