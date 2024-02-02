package Objects.PizzaTypes;

import Objects.Crust;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;
import java.util.List;

public class DiabloPizza implements Pizza {
        private Crust crust;
        private List<Ingredient> ingredients ;
        private List<Integer> quantities;

        public DiabloPizza(Crust crust){
            System.out.print("""
                
                -------------Diablo Pizza Configuration-------------
                
                """);
            this.ingredients=new ArrayList<>();
            this.quantities=new ArrayList<>();
            this.crust=crust;
            Ham ham = new Ham();
            ingredients.add(ham.add());
            Beef beef = new Beef();
            ingredients.add(beef.add());
            Bacon bacon = new Bacon();
            ingredients.add(bacon.add());
            Chicken chicken = new Chicken();
            ingredients.add(chicken.add());
            updateQuantities();
        }


        @Override
        public void prepare() {
            System.out.println("\nPreparing Diablo pizza...");
        }

        @Override
        public void bake() {
            System.out.println("\nBaking Diablo pizza...");
        }

        @Override
        public void cut() {
            System.out.println("\nCutting Diablo pizza...");
        }

        @Override
        public void box() {
            System.out.println("\nBoxing Diablo pizza...");
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
            System.out.println("Updating quantities for Diablo pizza...");
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
        return 11;
    }

    @Override
    public String getName() {
        return "Diablo";
    }
}
