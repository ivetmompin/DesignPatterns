package Patterns.BuilderPattern;

import Objects.Customer;
import Objects.Pizza;
import Objects.Crust;
import Utilities.Utilities;

import java.util.ArrayList;

//PATTERN: This class implements Builder Pattern
public class BuilderMenu {

    ArrayList<Integer> types;
    ArrayList<Crust> crusts;
    public BuilderMenu(Customer customer){
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
            PizzaBuilder builder = new PizzaBuilder();
            Pizza pizza = builder.setType(types.get(i)).setCrust(crusts.get(i)).build();
            System.out.println("-----------Builder Pattern-----------");
            utilities.printPizza(pizza);
        }
    }
}
