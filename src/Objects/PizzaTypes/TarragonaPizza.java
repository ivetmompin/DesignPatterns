package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class TarragonaPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients;
    private List<Integer> quantities;

    public TarragonaPizza(Crust crust) {
        System.out.print("""
                
                -------------Tarragona Pizza Configuration-------------
                
                """);
        this.ingredients = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.crust=crust;

        Tuna tuna= new Tuna();
        ingredients.add(tuna.add());
        Prawn prawn = new Prawn();
        ingredients.add(prawn.add());
        Onion onion = new Onion();
        ingredients.add(onion.add());
        Ham ham = new Ham();
        ingredients.add(ham.add());
        Olives olives = new Olives();
        ingredients.add(olives.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Tarragona pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Tarragona pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Tarragona pizza...");
    }

    @Override
    public void box() {
            System.out.println("\nBoxing Tarragona pizza...");
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
        System.out.println("Updating quantities for Tarragona pizza...");
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
        return 21;
    }

    @Override
    public String getName() {
        return "Tarragona";
    }
}