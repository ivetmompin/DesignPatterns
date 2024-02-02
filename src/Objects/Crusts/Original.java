package Objects.Crusts;

import Objects.Crust;

public class Original implements Crust {
    public Original(){
        set();
    }
    @Override
    public void set() {
        System.out.println("\nSetting Original Crust");
    }
}
