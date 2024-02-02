package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class SpanishPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients;
    private List<Integer> quantities;

    public SpanishPizza(Crust crust) {
        System.out.print("""
                
                -------------Spanish Pizza Configuration-------------
                
                """);
        this.ingredients = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.crust=crust;
        Iberic iberic= new Iberic();
        ingredients.add(iberic.add());
        Brie brie= new Brie();
        ingredients.add(brie.add());
        Olives olives = new Olives();
        ingredients.add(olives.add());
        Mushroom mushroom = new Mushroom();
        ingredients.add(mushroom.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Spanish pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Spanish pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Spanish pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Spanish pizza...");
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
        System.out.println("Updating quantities for Spanish pizza...");
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
        return 20;
    }

    @Override
    public String getName() {
        return "Spanish";
    }
}
