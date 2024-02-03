package Patterns.AbstractFactoryPattern;

import Objects.Crust;
import Objects.Customer;
import Objects.Drink;
import Objects.Pizza;
import Objects.PizzaTypes.*;
import Patterns.AbstractFactoryPattern.Factories.*;
import Utilities.Utilities;

import java.util.ArrayList;

//PATTERN: This class implements Abstract Factory Pattern
public class AbstractMenu {
    ArrayList<Integer> types;
    ArrayList<Crust> crusts;
    public AbstractMenu(Customer customer){
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
            Drink drink = utilities.askDrink(customer);
            customer.addToOrder(null,drink,"drink");
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
            PizzaAbstractFactory factory = getFactory(types.get(i));
            Pizza pizza = factory.createPizza(crusts.get(i));
            System.out.println("-----------Abstract Factory Pattern-----------");
            utilities.printPizza(pizza);
        }
    }

    public PizzaAbstractFactory getFactory(int type){
        return switch (type) {
            case 1 -> new AmericanPizzaFactory();
            case 2 -> new BaconCrispyPizzaFactory();
            case 3 -> new BarcelonaPizzaFactory();
            case 4 -> new BBQPizzaFactory();
            case 5 -> new BurgerPizzaFactory();
            case 6 -> new CarbonaraPizzaFactory();
            case 7 -> new CarbonaraDeluxePizzaFactory();
            case 8 -> new CastelleraPizzaFactory();
            case 9 -> new CoastPizzaFactory();
            case 10 -> new CowboyPizzaFactory();
            case 11 -> new DiabloPizzaFactory();
            case 12 -> new FourCheesePizzaFactory();
            case 13 -> new GironaPizzaFactory();
            case 14 -> new HawaiianPizzaFactory();
            case 15 -> new LleidaPizzaFactory();
            case 16 -> new MallorcaPizzaFactory();
            case 17 -> new MargheritaPizzaFactory();
            case 18 -> new PepperoniPizzaFactory();
            case 19 -> new SixCheesePizzaFactory();
            case 20 -> new SpanishPizzaFactory();
            case 21 -> new TarragonaPizzaFactory();
            case 22 -> new TexasPizzaFactory();
            case 23 -> new TraviataPizzaFactory();
            case 24 -> new VegetalPizzaFactory();
            default -> null;
        };
    }
}
