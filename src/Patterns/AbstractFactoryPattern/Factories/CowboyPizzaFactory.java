package Patterns.AbstractFactoryPattern.Factories;

import Objects.Crust;
import Objects.Pizza;
import Objects.PizzaTypes.CowboyPizza;
import Patterns.AbstractFactoryPattern.PizzaAbstractFactory;
import Utilities.Utilities;

public class CowboyPizzaFactory implements PizzaAbstractFactory {
    @Override
    public Pizza createPizza(Crust crust) {
        Pizza pizza = new CowboyPizza(crust);
        pizza.prepare();
        Utilities utilities = new Utilities();
        pizza=utilities.modifyPizza(pizza);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
