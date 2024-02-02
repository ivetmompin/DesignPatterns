package Objects;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final List<Drink> beverages;
    private final List<String> pizzas;

    public Order(){
       this.beverages = new ArrayList<>();
       this.pizzas = new ArrayList<>();
    }
    public List<Drink> getBeverages() {
        return beverages;
    }

    public List<String> getPizzas() {
        return pizzas;
    }
}
