package Objects.PizzaTypes;
import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.Bacon;
import Objects.Ingredients.Chicken;
import Objects.Ingredients.Ham;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class BaconCrispyPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public BaconCrispyPizza(Crust crust){
        System.out.print("""
                
                -------------Bacon Crispy Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        Ham ham = new Ham();
        ingredients.add(ham.add());
        Chicken chicken = new Chicken();
        ingredients.add(chicken.add());
        Bacon bacon = new Bacon();
        ingredients.add(bacon.add());
        updateQuantities();
    }

    @Override
    public void prepare() {
        System.out.println("\nPreparing Bacon Crispy pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Bacon Crispy pizza");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Bacon Crispy pizza");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Bacon Crispy pizza");
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
        System.out.println("Updating quantities for Bacon Crispy pizza...");
        Utilities utilities = new Utilities();
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

    public int getType(){
        return 2;
    }

    @Override
    public String getName() {
        return "Bacon Crispy";
    }
}
