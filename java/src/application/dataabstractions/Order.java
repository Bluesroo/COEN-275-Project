package application.dataabstractions;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import application.dataabstractions.*;

/**
 * @author David Obatake
 */
public class Order {
    private static int tag;

    private int orderTag;
    private Customer customer;
    private Date date;
    private double price;
    ArrayList<Labor> items;

    public Order() {
        this.orderTag = tag++;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = new Date();
        items = new ArrayList<>();
    }

    public Order(Customer info){
        this();
        this.customer = info;
    }

    public int getTag() {
        return orderTag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer info) {
        this.customer = info;
    }


    public Date getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

    public void updatePrice() {
        for(Labor l : items) {
            // Reset price
            price = 0;
            // then add all prices of items together
            price += l.getPrice();

            // @TODO Should we calculate sales tax here?
        }
    }

    public void addItem (Labor item) {
        items.add(item);
    }

    public void removeItem (Labor item)  {
        for(Labor l : items) {
            if(l.equals(item))
                items.remove(items.indexOf(l));
        }
    }
}
