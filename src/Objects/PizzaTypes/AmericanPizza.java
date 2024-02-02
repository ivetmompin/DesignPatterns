package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.Bacon;
import Objects.Ingredients.Egg;
import Objects.Ingredients.Frankfurt;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class AmericanPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public AmericanPizza(Crust crust){
        System.out.print("""
                
                -------------American Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust = crust;
        Frankfurt frankfurt = new Frankfurt();
        ingredients.add(frankfurt.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        Egg egg = new Egg();
        ingredients.add(egg.add());
        updateQuantities();
    }

    @Override
    public void prepare(){
        System.out.println("\nPreparing American pizza...\n");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking American Pizza");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting American Pizza");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing American Pizza");
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
        System.out.println("Updating quantities for American pizza...");
        System.out.println("ingredients length: "+ingredients.size());
        Utilities utilities = new Utilities();
        ArrayList<Boolean> marking = new ArrayList<>();
        marking = utilities.initMarking(marking,ingredients.size());
        for(Ingredient ingredient: this.ingredients){
            if(!marking.get(ingredients.indexOf(ingredient))&& !marking.isEmpty()) {
                quantities.add(utilities.countIngredientsOfTheClass(ingredients, ingredient, marking));
            }
        }
    }

    @Override
    public List<Integer> getQuantities() {
        return quantities;
    }

    public int getType() {
        return 1;
    }

    @Override
    public String getName() {
        return "American";
    }
}
