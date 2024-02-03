package Objects;

import Utilities.Utilities;
import java.io.*;
import java.util.*;

public class Customer {
    private String name;

    private Integer age;
    private String phone;
    private String email;
    private String deliveryAddress;
    private Boolean firstTime;
    private Integer delegation;

    private final Order order;

    public Customer(){order = new Order();}

    public Customer logIn(int step, Customer customer) {
        Scanner scanner = new Scanner(System.in);
        Utilities utilities = new Utilities();
        customer.setItIsFirstTime(false);
        switch(step){
            case 0 ->{
                System.out.print("Enter your name:\040");
                String name = scanner.next();
                if(name!=null&&isInDatabase(name)){
                    customer.setName(name);
                    return logIn(step+1,customer);
                }else{
                    utilities.printUserNotFound();
                    return logIn(step,customer);
                }
            }
            case 1 ->{
                System.out.print("Enter your email:\040");
                String email = scanner.next();
                if(email!=null&&email.contains("@")){
                    customer.setEmail(email);
                    customer=findCustomerInDatabase(customer);
                    if(customer==null){
                        utilities.printUserNotFound();
                        return logIn(step,new Customer());
                    }
                }else{
                    utilities.printUserNotFound();
                    return logIn(step,customer);
                }
            }
        }
        return customer;
    }

    private Customer findCustomerInDatabase(Customer customer) {
        List<Customer> customers = getCustomers();
        for(Customer customerAnalyzing: customers){
            if(Objects.equals(customerAnalyzing.getName(),customer.getName())){
                if(Objects.equals(customerAnalyzing.getEmail(),customer.getEmail())){
                    return customerAnalyzing;
                }
            }
        }
        return null;
    }

    public Customer register(int step, Customer customer){
        Utilities utilities = new Utilities();
        Scanner scanner = new Scanner(System.in);
        switch(step){
            case 0 ->{
                System.out.print("Enter your name:\040");
                String name = scanner.nextLine();
                if(name!=null&&!isInDatabase(name)){
                    customer.setName(name);
                    return register(step+1,customer);
                }else{
                    utilities.printErrorInput();
                    return register(step,customer);
                }
            }
            case 1 ->{
                System.out.print("Enter your age:\040");
                String age = scanner.nextLine();
                if(age!=null){
                    try {
                        customer.setAge(Integer.parseInt(age));
                        return register(step + 1, customer);
                    }catch(Exception e){
                        utilities.printErrorInput();
                        return register(step,customer);
                    }
                }else{
                    utilities.printErrorInput();
                    return register(step,customer);
                }
            }
            case 2 ->{
                System.out.print("Enter your phone:\040");
                String phone = scanner.nextLine();
                if(phone!=null){
                    customer.setPhone(phone);
                    return register(step+1,customer);
                }else{
                    utilities.printErrorInput();
                    return register(step,customer);
                }
            }
            case 3 ->{
                System.out.print("Enter your email:\040");
                String email = scanner.nextLine();
                if(email!=null&&email.contains("@")){
                    customer.setEmail(email);
                    return register(step+1,customer);
                }else{
                    utilities.printErrorInput();
                    return register(step,customer);
                }
            }
            case 4 ->{
                System.out.print("Enter your delivery address:\040");
                String deliveryAddress = scanner.nextLine();
                if(deliveryAddress!=null){
                    customer.setDeliveryAddress(deliveryAddress);
                    return register(step+1,customer);
                }else{
                    utilities.printErrorInput();
                    return register(step,customer);
                }
            }
            case 5 ->{
                Integer delegation = new Random().nextInt(1,5);
                customer.setDelegation(delegation);
                return register(step+1,customer);
            }
            case 6->{
                customer.setItIsFirstTime(true);
                registerCustomer(customer);
                utilities.printCorrectRegister();
            }
        }
        return customer;
    }

    public void setAge(int age) {
        this.age=age;
    }
    public Integer getAge() {
        return this.age;
    }

    private boolean isInDatabase(String name) {
        List<Customer> customers = getCustomers();
        for (Customer customer : customers) {
            if (Objects.equals(name, customer.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addToOrder(String pizza,Drink drink, String type) {
        switch(type){
            case "pizza" -> order.getPizzas().add(pizza);
            case "drink" -> order.getBeverages().add(drink);
        }
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public Boolean getItIsFirstTime() {
        return firstTime;
    }

    public Integer getDelegation() {
        return delegation;
    }
    public void setDelegation(Integer delegation) {
        this.delegation=delegation;
    }

    public Order getOrder(){
        return this.order;
    }

    public ArrayList<Customer> getCustomers() {
        Utilities utilities = new Utilities();
        ArrayList<Customer> fileData = new ArrayList<>();
        try {
            File file = new File("Files/customers.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                fileData.add(parseCustomer(st));
            }
        }catch(Exception e){
            utilities.printNoCustomers();
        }
        return fileData;
    }
    public void registerCustomer(Customer customer) {
        try {
            // Open the file in append mode by passing true as the second parameter
            FileWriter myWriter = new FileWriter("Files/customers.txt", true);

            // Construct the string to write
            String stringToWrite = customer.getName() + ";" + customer.getAge() + ";" + customer.getPhone() + ";" +
                    customer.getEmail() + ";" + customer.getDeliveryAddress() + ";" + customer.getItIsFirstTime() + ";" +
                    customer.getDelegation() + "\n";  // Add a newline to separate entries

            // Append the string to the file
            myWriter.append(stringToWrite);

            // Close the file
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    private Customer parseCustomer(String st) {
        String[] data = st.split(";");
        Customer customer = new Customer();
        customer.setName(data[0]);
        customer.setAge(Integer.parseInt(data[1]));
        customer.setPhone(data[2]);
        customer.setEmail(data[3]);
        customer.setDeliveryAddress(data[4]);
        customer.setItIsFirstTime(Boolean.getBoolean(data[5]));
        customer.setDelegation(Integer.parseInt(data[6]));
        return customer;
    }

    private void setName(String name) {
        this.name=name;
    }
    private void setPhone(String phone){
        this.phone=phone;
    }

    private void setEmail(String email){
        this.email=email;
    }

    public void setDeliveryAddress(String deliveryAddress){
        this.deliveryAddress=deliveryAddress;
    }

    private void setItIsFirstTime(boolean firstTime){
        this.firstTime=firstTime;
    }
}
