package Patterns.FactoryPattern;

import Objects.Crust;
import Objects.Pizza;
import Objects.PizzaTypes.*;
import Utilities.Utilities;

// Factory Pattern: BurgerFactory
public class PizzaFactory {
    public Pizza createPizza(int type, Crust crust) {
        Utilities utilities = new Utilities();
        return utilities.createPizzaByType(type,crust);
    }
}
