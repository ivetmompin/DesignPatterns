package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class MallorcaPizza implements Pizza {
    private Crust crust;
    private List<Ingredient> ingredients ;
    private List<Integer> quantities;

    public MallorcaPizza(Crust crust){
        System.out.print("""
                
                -------------Mallorca Pizza Configuration-------------
                
                """);
        this.ingredients=new ArrayList<>();
        this.quantities=new ArrayList<>();
        this.crust=crust;
        GoatCheese goatCheese= new GoatCheese();
        ingredients.add(goatCheese.add());
        Emmental emmental= new Emmental();
        ingredients.add(emmental.add());
        Cheddar cheddar = new Cheddar();
        ingredients.add(cheddar.add());
        Brie brie= new Brie();
        ingredients.add(brie.add());
        Sobrasada sobrassada = new Sobrasada();
        ingredients.add(sobrassada.add());
        Olives olives = new Olives();
        ingredients.add(olives.add());
        updateQuantities();
    }


    @Override
    public void prepare() {
        System.out.println("\nPreparing Mallorca pizza...");
    }

    @Override
    public void bake() {
        System.out.println("\nBaking Mallorca pizza...");
    }

    @Override
    public void cut() {
        System.out.println("\nCutting Mallorca pizza...");
    }

    @Override
    public void box() {
        System.out.println("\nBoxing Mallorca pizza...");
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
        System.out.println("Updating quantities for Mallorca pizza...");
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
        return 16;
    }

    @Override
    public String getName() {
        return "Mallorca";
    }
}

