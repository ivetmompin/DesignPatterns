package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CoastPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public CoastPizza(Crust crust){
        System.out.print("""
                
                -------------Coast Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Tuna tuna= new Tuna();
        ingredients.add(tuna.add());
        Anchovies anchovies= new Anchovies();
        ingredients.add(anchovies.add());
        Prawn prawn = new Prawn();
        ingredients.add(prawn.add());
        Pineapple pineapple = new Pineapple();
        ingredients.add(pineapple.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Coast pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Coast pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Coast pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Coast pizza...");
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
        System.out.println("Updating quantities for Coast pizza...");
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
        return 9;
    }

    @Override
    public String getName() {
        return "Coast";
    }
}

