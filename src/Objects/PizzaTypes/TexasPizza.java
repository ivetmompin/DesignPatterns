package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class TexasPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients;
    private List<Integer> quantities;

    public TexasPizza(Crust crust) {
        System.out.print("""
                
                -------------Texas Pizza Configuration-------------
                
                """);
        this.ingredients = new ArrayList<>();
        this.quantities = new ArrayList<>();
        this.crust=crust;
        BBQSauce bbqSauce= new BBQSauce();
        ingredients.add(bbqSauce.add());
        Onion onion= new Onion();
        ingredients.add(onion.add());
        Tomato tomato = new Tomato();
        ingredients.add(tomato.add());
        Chicken chicken = new Chicken();
        ingredients.add(chicken.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Texas pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Texas pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Texas pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Texas pizza...");
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
        System.out.println("Updating quantities for Texas pizza...");
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
        return 22;
    }

    @Override
    public String getName() {
        return "Texas";
    }
}
