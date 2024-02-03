package Utilities;

import Objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utilities {
    private final UI ui;
    private final SharedPrints sharedPrints;
    Scanner scanner;
    public Utilities(){
        scanner = new Scanner(System.in);
        ui = new UI();
        sharedPrints = new SharedPrints();
    }

    public int askLoginOrSignUp(){
        return ui.askLoginOrSignUp();
    }

    public void printCustomer(Customer customer, int indexFile){
        sharedPrints.printCustomer(customer,indexFile);
    }

    public int askPizza(Customer customer){
        return ui.askPizza(customer);
    }

    public Crust askCrust(){
        return ui.askCrust();
    }

    public Pizza createPizzaByType(int type,Crust crust){
        return ui.createPizzaByType(type,crust);
    }

    public ArrayList<Boolean> initMarking(ArrayList<Boolean> marking, int sizeIngredients){
        return sharedPrints.initMarking(sizeIngredients);
    }

    public void printPizza(Pizza pizza){
        sharedPrints.printPizza(pizza);
    }

    public int countIngredientsOfTheClass(List<Ingredient> ingredients, Ingredient currentIngredient, ArrayList<Boolean> marking) {
        return sharedPrints.countIngredientsOfTheClass(ingredients, currentIngredient, marking);
    }
    public int askPattern() {
        return ui.askPattern();
    }

    public void printFinished() {
        sharedPrints.printFinished();
    }
    public Pizza modifyPizza(Pizza pizza){
        return ui.modifyPizza(pizza);
    }

    public String getPizzaNameByType(int type){
        return sharedPrints.getPizzaNameByType(type);
    }

    public boolean askMultiple() {
        return ui.askMultiple();
    }

    public void printErrorTooManyTooFew(boolean manyOrFew, String element){
        ui.printErrorTooManyTooFew(manyOrFew,element);
    }

    public void printOrder(Customer customer){
        sharedPrints.printOrder(customer);
    }

    public Drink askDrink(Customer customer) {
        return ui.askDrink(customer);
    }

    public Customer askAddressConfirmation(Customer customer) {
        return ui.askAddressConfirmation(customer);
    }
    public void printErrorInput() {
        ui.printErrorInput();
    }

    public void printUserNotFound(){
        sharedPrints.printUserNotFound();
    }
    public void printNoCustomers(){
        sharedPrints.printNoCustomers();
    }

    public void printCorrectRegister(){
        sharedPrints.printCorrectRegister();
    }

}
