package dataabstractions;

import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class Customer {
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private ArrayList<Order> orders;

    public Customer() {}

    public Customer(String lname, String fname, String email) {
        this.firstname = fname;
        this.lastname = lname;
        this.email = email;
        this.orders = new ArrayList<>();
    }

    public Customer(String lname, String fname, String email, String phone) {
        this(lname, fname, email);
        this.phone = phone;
    }

    public String getFirstName() {
        return this.firstname;
    }

    public void setFirstName(String name) {
        this.firstname = name;
    }

    public String getLastname() {return this.lastname; }

    public void setLastname(String name) { this.lastname = name; }

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
        if(c.getFirstName().equals(this.firstname) &&
                c.getLastname().equals(this.lastname) &&
                c.getEmail().equals(this.email))
            return true;

        return false;
    }
}
