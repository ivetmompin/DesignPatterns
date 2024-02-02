package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class CastelleraPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public CastelleraPizza(Crust crust){
        System.out.print("""
                
                -------------Castellera Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Onion onion = new Onion();
        ingredients.add(onion.add());
        Tuna tuna= new Tuna();
        ingredients.add(tuna.add());
        Pepperoni pepperoni = new Pepperoni();
        ingredients.add(pepperoni.add());
        Olives olives = new Olives();
        ingredients.add(olives);
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Castellera pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Castellera pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Castellera pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Castellera pizza...");
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
        System.out.println("Updating quantities for Castellera pizza...");
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
        return 8;
    }

    @Override
    public String getName() {
        return "Castellera";
    }
}
