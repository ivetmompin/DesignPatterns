package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class LleidaPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public LleidaPizza(Crust crust){
        System.out.print("""
                
                -------------Lleida Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        BBQSauce bbqSauce= new BBQSauce();
        ingredients.add(bbqSauce.add());
        Beef beef= new Beef();
        ingredients.add(beef.add());
        Chicken chicken = new Chicken();
        ingredients.add(chicken.add());
        Mushroom mushroom= new Mushroom();
        ingredients.add(mushroom.add());
        Olives olives = new Olives();
        ingredients.add(olives.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Lleida pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Lleida pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Lleida pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Lleida pizza...");
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
        System.out.println("Updating quantities for Lleida pizza...");
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
        return 15;
    }

    @Override
    public String getName() {
        return "Lleida";
    }
}

