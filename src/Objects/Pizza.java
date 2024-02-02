package Objects;

import java.util.List;

public interface Pizza {
    void prepare();
    void bake();
    void cut();
    void box();

    List<Ingredient> getIngredients();

    Crust getCrust();

    void updateQuantities();

    List<Integer> getQuantities();

    int getType();

    String getName();
}
