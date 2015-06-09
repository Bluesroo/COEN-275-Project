package databasegui;

import dataabstractions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel {

    ActionListener radioListener;

    ContentPanel() {
        setBackground(Color.WHITE);
    }

    boolean setContent(ArrayList<ShopData> array) {
        removeAll();

        boolean setSuccess;

        if (array.get(0) instanceof Customer) {
            modifyLayout(5);
            setSuccess = setCustomers(array);
        } else if (array.get(0) instanceof Order) {
            setSuccess = setOrders(array);
            modifyLayout(4);
        } else {
            System.out.println("Trying to display invalid array type.");
            setSuccess = false;
        }
        return setSuccess;
    }

    private boolean setCustomers(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return false;
        }

        add(new JLabel("Select"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));
        add(new JLabel("Phone Number"));
        add(new JLabel("Email"));

        for (ShopData data : array) {
            Customer customer = ((Customer) data);
            JRadioButton select = new JRadioButton(customer.getID());
            select.addActionListener(radioListener);
            add(select);
            add(new JLabel(customer.getLastName()));
            add(new JLabel(customer.getFirstName()));
            add(new JLabel(customer.getPhone()));
            add(new JLabel(customer.getEmail()));
        }
        return true;
    }

    private boolean setOrders(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return false;
        }

        add(new JLabel("Order Tag"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));

        for (ShopData data : array) {
            Order order = ((Order) data);
            add(new JLabel("" + order.getTag()));
            add(new JLabel(order.getCustomer().getLastName()));
            add(new JLabel(order.getCustomer().getFirstName()));
        }
        return true;
    }

    void setContentListener(ActionListener radioListener) {
        this.radioListener = radioListener;
    }

    private void modifyLayout(int columnCount) {
        setLayout(new GridLayout(0, columnCount));
    }
}
