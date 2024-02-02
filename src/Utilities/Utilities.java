package Utilities;

import Objects.Crust;
import Objects.Crusts.Original;
import Objects.Crusts.Sicilian;
import Objects.Crusts.Thin;
import Objects.Customer;
import Objects.Ingredient;
import Objects.Ingredients.*;
import Objects.Pizza;
import Objects.Drink;
import Objects.PizzaTypes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Utilities {
    private UI ui;
    private SharedPrints sharedPrints;
    Scanner scanner;
    public Utilities(){
        scanner = new Scanner(System.in);
        ui = new UI();
        sharedPrints = new SharedPrints();
    }

    public ArrayList<Boolean> initMarking(ArrayList<Boolean> marking, int sizeIngredients){
        marking = new ArrayList<>(sizeIngredients);
        for (int i = 0; i < sizeIngredients; i++) {
            marking.add(false);
        }
        return marking;
    }

    public void printPizza(Pizza pizza){}

    public int countIngredientsOfTheClass(List<Ingredient> ingredients, Ingredient currentIngredient, ArrayList<Boolean> marking) {
        int quantity = 0;
        for(int i=0;i<ingredients.size();i++){
            if(Objects.equals(ingredients.get(i).getName(),currentIngredient.getName())){
                marking.set(i,true);
                quantity++;
            }
        }
        return quantity;
    }

    public String getIngredient(Ingredient ingredient){
        return ingredient.getName();
    }

    public String getPizzaStringType(Pizza pizza){
        return pizza.getName();
    }

    public Pizza createPizzaByType(int type, Crust crust){
        Pizza pizza = switch (type) {
            case 1 -> new AmericanPizza(crust);
            case 2 -> new BaconCrispyPizza(crust);
            case 3 -> new BarcelonaPizza(crust);
            case 4 -> new BBQPizza(crust);
            case 5 -> new BurgerPizza(crust);
            case 6 -> new CarbonaraPizza(crust);
            case 7 -> new CarbonaraDeluxePizza(crust);
            case 8 -> new CastelleraPizza(crust);
            case 9 -> new CoastPizza(crust);
            case 10 -> new CowboyPizza(crust);
            case 11 -> new DiabloPizza(crust);
            case 12 -> new FourCheesePizza(crust);
            case 13 -> new GironaPizza(crust);
            case 14 -> new HawaiianPizza(crust);
            case 15 -> new LleidaPizza(crust);
            case 16 -> new MallorcaPizza(crust);
            case 17 -> new MargheritaPizza(crust);
            case 18 -> new PepperoniPizza(crust);
            case 19 -> new SixCheesePizza(crust);
            case 20 -> new SpanishPizza(crust);
            case 21 -> new TarragonaPizza(crust);
            case 22 -> new TexasPizza(crust);
            case 23 -> new TraviataPizza(crust);
            case 24 -> new VegetalPizza(crust);
            default -> null;
        };
        if(pizza!=null) {
            pizza=modifyPizza(pizza);
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        }
        return pizza;
    }

    public int askLoginOrSignUp(){
        int option = 0;
        while(option!=1&&option!=2) {
            System.out.print("""
                    ----Welcome to PizziSalle----
                    Is it your first time in PizziSalle?
                    \t1) No
                    \t2) Yes
                    Enter your choice [1,2]:\040""");
            option = scanner.nextInt();
            if(option!=1&&option!=2){
                System.out.println(ANSI_RED+"\tWrong option. Try again"+ANSI_RESET);
            }
        }
        return option;
    }
    public int askPizza(Customer customer) {
        int request=0;
        while(request==0) {
            System.out.print("""
         
            Which pizza would you like to eat?
                \t1) American
                \t2) BaconCrispy
                \t3) Barcelona
                \t4) BBQ
                \t5) Burger
                \t6) Carbonara
                \t7) CarbonaraDeluxe
                \t8) Castellera
                \t9) Coast
                \t10) Cowboy
                \t11) Diablo
                \t12) FourCheese
                \t13) Girona
                \t14) Hawaiian
                \t15) Lleida
                \t16) Mallorca
                \t17) Margherita
                \t18) Pepperoni
                \t19) SixCheese
                \t20) Spanish
                \t21) Tarragona
                \t22) Texas
                \t23) Traviata
                \t24) Vegetal
                    Your choice [1-24]:\040""");
            try {
                request = scanner.nextInt();
                boolean error = false;
                if(request<1||request>24){
                    System.out.println("Wrong option");
                    request = 0;
                }else {
                    switch (customer.getDelegation()) {
                        case 1 -> {
                            if (request == 13 || request == 15 || request == 21) {
                                error = true;
                            }
                        }
                        case 2 -> {
                            if (request == 3 || request == 15 || request == 21) {
                                error = true;
                            }
                        }
                        case 3 -> {
                            if (request == 3 || request == 13 || request == 21) {
                                error = true;
                            }
                        }
                        case 4 -> {
                            if (request == 3 || request == 13 || request == 15) {
                                error = true;
                            }
                        }
                    }
                    if (error) {
                        System.out.println(ANSI_RED + "pizza " + request + " is not available in " + getDelegationString(customer.getDelegation()) + ANSI_RESET);
                        request = 0;
                    }
                }
            }catch(Exception e){
                System.out.println("wrong option format");
                request=0;
            }
        }
        return request;
    }

    public Crust askCrust() {
        int option = 0;
        while(option<1||option>3) {
            System.out.print("""
                
                Which kind of crust do you want for your pizza?
                \t1) Original
                \t2) Sicilian
                \t3) Thin
                Enter your choice [1,3]:\040""");
            option = scanner.nextInt();
            if(option<1||option>3){
                System.out.println(ANSI_RED+"\tWrong option. Try again"+ANSI_RESET);
            }
        }
        return switch(option){
            case 1 -> new Original();
            case 2 -> new Sicilian();
            case 3 -> new Thin();
            default -> null;
        };
    }

    public int askPattern() {
        int option = 0;
        while(option<1||option>4) {
            System.out.print("""
                Which design pattern do you want to use to create your order?
                \t1) Abstract Factory
                \t2) Builder
                \t3) Factory
                \t4) Singleton
                Enter your choice [1,4]:\040""");
            option = scanner.nextInt();
            if(option<1||option>4){
                System.out.println(ANSI_RED + "\tWrong option. Try again" + ANSI_RESET);
            }
        }
        return option;
    }

    public void printFinished() {
        System.out.println(ANSI_GREEN + "Your order has been finished! ✓" + ANSI_RESET);
    }
    public Pizza modifyPizza(Pizza pizza){
        int option=0;
        while(option!=1&&option!=2) {
            System.out.print("""
                                    
                    Would you like to modify your pizza?
                    \t1) Yes
                    \t2) No
                    Enter your option[1,2]:\040""");
            option = scanner.nextInt();
            if (option != 1 && option != 2) {
                System.out.println(ANSI_RED + "\tWrong option. Try again" + ANSI_RESET);
            }
        }
        if(option==1){
            option = 0;
            while(option!=1&&option!=2) {
                System.out.print("""
                                    
                    What would you like to do?
                    \t1) Add Ingredient
                    \t2) Remove Ingredient
                    Enter your option[1,2]:\040""");
                option = scanner.nextInt();
                if (option != 1 && option != 2) {
                    System.out.println(ANSI_RED + "\tWrong option. Try again" + ANSI_RESET);
                }
            }
            switch(option){
                case 1 -> addIngredient(pizza);
                case 2 -> removeIngredient(pizza);
            };
            modifyPizza(pizza);
        }
        return pizza;
    }

    public String getPizzaNameByType(int type){
        String[] pizzaTypes = {"American","Bacon Crispy","Barcelona","BBQ","Burger","Carbonara Deluxe","Carbonara","Castellera",
        "Coast","Cowboy","Diablo","Four Cheeses","Girona Pizza","Hawaiian","Lleida","Mallorca","Margherita","Pepperoni",
        "Six Cheeses","Spanish","Tarragona","Texas","Traviata","Vegetal"};
        return pizzaTypes[type];
    }

    private void addIngredient(Pizza pizza) {
        if(pizza.getIngredients().size()==10) {
            printErrorTooManyTooFew(true,"Ingredients");
        }else {
            System.out.print("""
                    Which ingredient would you like to add?
                    \t1) Anchovies
                    \t2) Artichoke
                    \t3) Bacon
                    \t4) BBQSauce
                    \t5) Beef
                    \t6) BellPepper
                    \t7) Brie
                    \t8) CarbonaraSauce
                    \t9) Cheddar
                    \t10) Chicken
                    \t11) Egg
                    \t12) Emmental
                    \t13) Frankfurt
                    \t14) Goat
                    \t15) Ham
                    \t16) Honey
                    \t17) Iberic
                    \t18) MiniBurger
                    \t19) Mozarella
                    \t20) Mushrooms
                    \t21) Olives
                    \t22) Onion
                    \t23) Pepperoni
                    \t24) Pineapple
                    \t25) Prawns
                    \t26) Roquefort
                    \t27) Sausage
                    \t28) Sobrasada
                    \t29) Tomato
                    \t30) Tuna
                    Your choice [1,29]:\040""");
            int option = scanner.nextInt();
            Ingredient ingredient = switch (option) {
                case 1 -> new Anchovies();
                case 2 -> new Artichoke();
                case 3 -> new Bacon();
                case 4 -> new BBQSauce();
                case 5 -> new Beef();
                case 6 -> new BellPepper();
                case 7 -> new Brie();
                case 8 -> new CarbonaraSauce();
                case 9 -> new Cheddar();
                case 10 -> new Chicken();
                case 11 -> new Egg();
                case 12 -> new Emmental();
                case 13 -> new Frankfurt();
                case 14 -> new GoatCheese();
                case 15 -> new Ham();
                case 16 -> new Honey();
                case 17 -> new Iberic();
                case 18 -> new Miniburger();
                case 19 -> new Mozarella();
                case 20 -> new Mushroom();
                case 21 -> new Olives();
                case 22 -> new Onion();
                case 23 -> new Pepperoni();
                case 24 -> new Pineapple();
                case 25 -> new Prawn();
                case 26 -> new Roquefort();
                case 27 -> new Sausage();
                case 28 -> new Sobrasada();
                case 29 -> new Tomato();
                case 30 -> new Tuna();
                default -> null;
            };
            if (ingredient != null) {
                pizza.getIngredients().add(ingredient.add());
                pizza.updateQuantities();
            }
        }
    }

    private void removeIngredient(Pizza pizza) {
        System.out.println("Which ingredient would you like to add?");
        int i;
        for(i=0;i<pizza.getIngredients().size();i++){
            Ingredient current = pizza.getIngredients().get(i);
            System.out.println("\t"+(i+1)+") "+current.getName());
        }
        System.out.println("Enter your option[1,"+i+"]:\040");
        int option = scanner.nextInt();
        if(!pizza.getIngredients().isEmpty()) {
            Ingredient ingredient = pizza.getIngredients().get(option - 1);
            pizza.getIngredients().remove(ingredient.remove(option - 1));
            pizza.updateQuantities();
        }else{
             printErrorTooManyTooFew(false,"Ingredients");
        }
    }

    public boolean askMultiple() {
        int option = 0;
        while(option<1||option>2) {
            System.out.print("""
                
                Would you like to order another pizza?
                \t1) Yes
                \t2) No
                Enter your choice [1,2]:\040""");
            option = scanner.nextInt();
            if(option<1||option>2){
                System.out.println(ANSI_RED+"\tWrong option. Try again"+ANSI_RESET);
            }
        }
        return switch(option){
            case 1 -> true;
            case 2 -> false;
            default -> false;
        };
    }

    public void printErrorTooManyTooFew(boolean manyOrFew, String element){
        if (manyOrFew) {
            System.out.println(ANSI_RED + "\tToo many " + element + ". Maximum number is 10" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "\tNo " + element + ". Can't carry on" + ANSI_RESET);
        }
    }

    public void printOrder(Customer customer){
        System.out.print("""
                
                --------CURRENT ORDER---------
                
                """);
        List<String> pizzas = customer.getOrder().getPizzas();
        List<Drink> drinks = customer.getOrder().getBeverages();
        System.out.println(ANSI_BOLD + "Pizzas:" + ANSI_RESET);
        for (String pizza : pizzas) {
            System.out.println("- "+pizza);
        }
        System.out.println(ANSI_BOLD + "Drinks:" + ANSI_RESET);
        for (Drink drink : drinks) {
            System.out.println(" - " + drink.name());
        }
    }
}
