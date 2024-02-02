package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class CarbonaraDeluxePizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public CarbonaraDeluxePizza(Crust crust){
        System.out.print("""
                
                -------------Carbonara Deluxe Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        CarbonaraSauce carbonaraSauce = new CarbonaraSauce();
        ingredients.add(carbonaraSauce.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        Onion onion = new Onion();
        ingredients.add(onion.add());
        Mushroom mushroom= new Mushroom();
        ingredients.add(mushroom.add());
        GoatCheese goatCheese = new GoatCheese();
        ingredients.add(goatCheese.add());
        Honey honey = new Honey();
        ingredients.add(honey.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Carbonara Deluxe pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Carbonara Deluxe pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Carbonara Deluxe pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Carbonara Deluxe pizza...");
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
        System.out.println("Updating quantities for Carbonara Deluxe pizza...");
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
        return 7;
    }

    @Override
    public String getName() {
        return "Carbonara Deluxe";
    }
}
