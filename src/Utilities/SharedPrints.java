package Utilities;

import Objects.Customer;
import Objects.Drink;
import Objects.Ingredient;
import Objects.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SharedPrints{

    ArrayList<Boolean> marking = new ArrayList<>();
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";
    String ANSI_BOLD = "\u001B[1m";
    String ANSI_RESET = "\u001B[0m";
    public SharedPrints(){

    }
    public void printCustomer(Customer customer, int indexInFile){
        System.out.println("-----CUSTOMER "+indexInFile+"-----");
        System.out.println("\tName: "+customer.getName());
        System.out.println("\tAge: "+customer.getAge());
        System.out.println("\tEmail: "+customer.getEmail());
        System.out.println("\tTelephone: "+customer.getPhone());
        System.out.println("\tDelivery Address: "+customer.getDeliveryAddress());
        System.out.println("\tDelegation: "+getDelegationString(customer.getDelegation()));
    }

    public String getDelegationString(int delegation){
        return switch(delegation){
            case 1 -> "Barcelona";
            case 2 -> "Girona";
            case 3 -> "Lleida";
            case 4 -> "Tarragona";
            default -> "";
        };
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
            if(drink!=null) {
                System.out.println(" - " + drink.name());
            }
        }
    }
    public void printFinished() {
        System.out.println(ANSI_GREEN + "Your order has been finished! ✓" + ANSI_RESET);
    }
    public ArrayList<Boolean> initMarking(int sizeIngredients){
        ArrayList<Boolean> marking = new ArrayList<>(sizeIngredients);
        for (int i = 0; i < sizeIngredients; i++) {
            marking.add(false);
        }
        return marking;
    }

    public void printPizza(Pizza pizza){
        System.out.println("Your pizza: ");
        System.out.println("\tType: "+getPizzaStringType(pizza));
        System.out.println("\t---Ingredients---");
        marking = initMarking(pizza.getIngredients().size());
        for(int i=0;i<pizza.getIngredients().size();i++) {
            if(!marking.get(i)) {
                Ingredient currentIngredient = pizza.getIngredients().get(i);
                int quantity = countIngredientsOfTheClass(pizza.getIngredients(), currentIngredient, marking);
                System.out.println("\t\t - " + getIngredient(currentIngredient)+" (x"+quantity+")");
            }
        }
    }

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

    public String getPizzaNameByType(int type) {
        String[] pizzaTypes = {"American", "Bacon Crispy", "Barcelona", "BBQ", "Burger", "Carbonara Deluxe", "Carbonara", "Castellera",
                "Coast", "Cowboy", "Diablo", "Four Cheeses", "Girona Pizza", "Hawaiian", "Lleida", "Mallorca", "Margherita", "Pepperoni",
                "Six Cheeses", "Spanish", "Tarragona", "Texas", "Traviata", "Vegetal"};
        return pizzaTypes[type];
    }

    public void printCorrectRegister() {
        System.out.println(ANSI_GREEN+"You have been correctly added to the system"+ANSI_RESET);
    }

    public void printNoCustomers() {
        System.out.println(ANSI_GREEN+"There are no customers stored in the system"+ANSI_RESET);
    }

    public void printUserNotFound() {
        System.out.println(ANSI_RED+" User not found in database. Try again "+ANSI_RESET);
    }
}
