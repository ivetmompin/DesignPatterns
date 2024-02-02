package Patterns.FactoryPattern;

import Objects.Crust;
import Objects.Customer;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;

//PATTERN: This class implements Factory Pattern
public class FactoryMenu {
    ArrayList<Integer> types;
    ArrayList<Crust> crusts;
    public FactoryMenu(Customer customer){

        Utilities utilities = new Utilities();
        types = new ArrayList<>();
        crusts = new ArrayList<>();
        boolean carryOn = true;
        while(carryOn) {
            int type = utilities.askPizza(customer);
            Crust crust = utilities.askCrust();
            types.add(type);
            crusts.add(crust);
            customer.addToOrder(utilities.getPizzaNameByType(type-1),null,"pizza");
            carryOn = utilities.askMultiple();
            if(types.size()==10){
                utilities.printErrorTooManyTooFew(true,"pizzas ordered");
                carryOn = false;
            }else if(types.isEmpty()){
                utilities.printErrorTooManyTooFew(false,"pizzas ordered");
                carryOn = true;
            }
            utilities.printOrder(customer);
            String drink = utilities.askDrink()
        }

        for(int i=0;i<types.size();i++) {
            //implementation pattern
            PizzaFactory factory = new PizzaFactory();
            Pizza pizza = factory.createPizza(types.get(i), crusts.get(i));
            System.out.println("-----------Factory Pattern-----------");
            utilities.printPizza(pizza);
        }
    }
}
