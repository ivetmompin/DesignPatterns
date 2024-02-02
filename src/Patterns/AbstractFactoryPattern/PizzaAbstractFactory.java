package Patterns.AbstractFactoryPattern;

import Objects.Crust;
import Objects.Pizza;

// Abstract Factory Pattern: BurgerAbstractFactory
public interface PizzaAbstractFactory {
    Pizza createPizza(Crust crust);
}
