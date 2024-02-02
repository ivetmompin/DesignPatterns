package Objects.Crusts;

import Objects.Crust;

public class Sicilian implements Crust {
    public Sicilian(){
        set();
    }
    @Override
    public void set() {
        System.out.println("Setting Sicilian Crust");
    }
}
