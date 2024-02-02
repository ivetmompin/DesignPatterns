package Utilities;

import Objects.Crust;
import Objects.Crusts.Original;
import Objects.Crusts.Sicilian;
import Objects.Crusts.Thin;
import Objects.Customer;
import Objects.Ingredient;
import Objects.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    ArrayList<Boolean> marking = new ArrayList<>();
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BOLD = "\u001B[1m";
    String ANSI_RESET = "\u001B[0m";

    Scanner scanner;

    public UI(){scanner = new Scanner(System.in);}

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
}
