import Objects.Customer;
import Patterns.AbstractFactoryPattern.AbstractMenu;
import Patterns.BuilderPattern.BuilderMenu;
import Patterns.FactoryPattern.FactoryMenu;
import Patterns.SingletonPattern.SingletonMenu;
import Utilities.Utilities;

public class Main {
    public static void main(String[] args) {
        Utilities utilities = new Utilities();

        // Login / SignUp
        int option = utilities.askLoginOrSignUp();
        Customer customer=new Customer();
        switch (option){
            case 1 ->{
                Customer login = new Customer();
                customer = login.logIn(0, new Customer());
            }
            case 2 -> {
                Customer signUp = new Customer();
                customer = signUp.register(0,new Customer());
            }
        }
        int customerIndex = customer.getCustomers().indexOf(customer);
        utilities.printCustomer(customer,customerIndex);
        customer = utilities.askAddressConfirmation(customer);
        // ask pattern
        option = utilities.askPattern();
        switch(option){
            case 1 -> new AbstractMenu(customer);
            case 2 -> new BuilderMenu(customer);
            case 3 -> new FactoryMenu(customer);
            case 4 -> new SingletonMenu(customer);
        }
        utilities.printFinished();
    }
}