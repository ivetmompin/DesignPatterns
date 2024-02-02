package Patterns.BuilderPattern;
import Objects.Crust;
import Objects.Pizza;
import Utilities.Utilities;


// Builder Pattern: BurgerBuilder
public class PizzaBuilder {
    private int type;
    private Crust crust;

    public PizzaBuilder setType(int type) {
        this.type = type;
        return this;
    }

    public PizzaBuilder setCrust(Crust crust){
        this.crust=crust;
        return this;
    }

    public Pizza build() {
        Utilities utilities = new Utilities();
        return utilities.createPizzaByType(type,crust);
    }
}
