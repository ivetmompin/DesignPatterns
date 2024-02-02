package Patterns.AbstractFactoryPattern.Factories;

import Objects.Crust;
import Objects.Pizza;
import Objects.PizzaTypes.CastelleraPizza;
import Patterns.AbstractFactoryPattern.PizzaAbstractFactory;
import Utilities.Utilities;

public class CastelleraPizzaFactory implements PizzaAbstractFactory {
    @Override
    public Pizza createPizza(Crust crust) {
        Pizza pizza = new CastelleraPizza(crust);
        pizza.prepare();
        Utilities utilities = new Utilities();
        pizza=utilities.modifyPizza(pizza);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}