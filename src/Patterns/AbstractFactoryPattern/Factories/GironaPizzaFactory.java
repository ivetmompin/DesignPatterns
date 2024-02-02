package Patterns.AbstractFactoryPattern.Factories;

import Objects.Crust;
import Objects.Pizza;
import Objects.PizzaTypes.GironaPizza;
import Patterns.AbstractFactoryPattern.PizzaAbstractFactory;
import Utilities.Utilities;

public class GironaPizzaFactory implements PizzaAbstractFactory {
    @Override
    public Pizza createPizza(Crust crust) {
        Pizza pizza = new GironaPizza(crust);
        pizza.prepare();
        Utilities utilities = new Utilities();
        pizza=utilities.modifyPizza(pizza);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
