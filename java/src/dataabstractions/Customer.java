package dataabstractions;

import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class Customer implements ShopData{
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private ArrayList<Order> orders;

    public Customer() {}

    public Customer(String lname, String fname, String email) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public Customer(String lname, String fname, String email, String phone) {
        this(lname, fname, email);
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {return this.lastName; }

    public void setLastName(String name) { this.lastName = name; }

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
        return c.getFirstName().equals(this.firstName) &&
                c.getLastName().equals(this.lastName) &&
                c.getEmail().equals(this.email);
    }
}
