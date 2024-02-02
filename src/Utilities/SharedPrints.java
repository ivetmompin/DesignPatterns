package Utilities;

import Objects.Customer;
import Objects.Drink;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println(" - " + drink.name());
        }
    }
}
