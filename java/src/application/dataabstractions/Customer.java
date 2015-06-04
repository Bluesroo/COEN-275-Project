package application.dataabstractions;

import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class Customer {
    private String name;
    private String phone;
    private String email;
    private ArrayList<Order> orders;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public Customer(String name, String email, String phone) {
        this(name, email);
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        if("".equals(this.phone))
            return "No # listed";

        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean equals(Customer c){
        if(c.getName().equals(this.name) &&
                c.getEmail().equals(this.email))
            return true;

        return false;
    }
}
