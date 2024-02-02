package Patterns.SingletonPattern;

import Objects.Crust;
import Objects.Pizza;
import Patterns.FactoryPattern.PizzaFactory;

// Singleton Pattern: BurgerRestaurant
public class PizzaRestaurant {
    private static PizzaRestaurant instance;

    private PizzaRestaurant() {
        // private constructor to prevent instantiation
    }

    public static PizzaRestaurant getInstance() {
        if (instance == null) {
            instance = new PizzaRestaurant();
        }
        return instance;
    }

    public Pizza orderPizza(int type, Crust crust) {
        PizzaFactory factory = new PizzaFactory();
        return factory.createPizza(type,crust);
    }
}
