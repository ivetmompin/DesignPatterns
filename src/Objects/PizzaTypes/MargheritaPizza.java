package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class MargheritaPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public MargheritaPizza(Crust crust){
        System.out.print("""
                
                -------------Margherita Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Margherita pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Margherita pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Margherita pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Margherita pizza...");
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
        System.out.println("Updating quantities for Margherita pizza...");
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
        return 17;
    }

    @Override
    public String getName() {
        return "Margherita";
    }
}

