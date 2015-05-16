package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Mugen on 5/15/15.
 */
public class Order {
    private static int tag;
    private int orderTag;
    private Date date;
    private double price;
    ArrayList<Labor> items;

    public Order() {
        this.orderTag = tag++;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        this.date = new Date();
        items = new ArrayList<Labor>();
    }

    public int getTag() {
        return orderTag;
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
