package Objects.Crusts;

import Objects.Crust;

public class Thin implements Crust {

    public Thin(){
        set();
    }
    @Override
    public void set() {
        System.out.println("Setting Thin Crust");
    }
}
