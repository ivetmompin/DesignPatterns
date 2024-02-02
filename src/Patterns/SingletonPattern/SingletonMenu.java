package Patterns.SingletonPattern;

import Objects.Crust;
import Objects.Customer;
import Objects.Pizza;
import Utilities.Utilities;

import java.util.ArrayList;

//PATTERN: This class implements Singleton Pattern
public class SingletonMenu {
    ArrayList<Integer> types;
    ArrayList<Crust> crusts;
    public SingletonMenu(Customer customer){

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
        }
        for(int i=0;i<types.size();i++) {
            //implementation pattern
            PizzaRestaurant restaurant = PizzaRestaurant.getInstance();
            Pizza pizza = restaurant.orderPizza(types.get(i), crusts.get(i));
            System.out.println("-----------Builder Pattern-----------");
            utilities.printPizza(pizza);
        }
    }
}
