package databasegui;

import dataabstractions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel {

    ActionListener radioListener;

    ContentPanel() {
        setBackground(Color.WHITE);
    }

    void setContent(ArrayList<ShopData> array) {
        removeAll();

        if (array.get(0) instanceof Customer) {
            modifyLayout(5);
            setCustomers(array);
        } else if (array.get(0) instanceof Order) {
            setOrders(array);
            modifyLayout(3);
        } else {
            System.out.println("Trying to display invalid array type.");
        }
    }

    private void setCustomers(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return;
        }

        ButtonGroup group = new ButtonGroup();

        add(new JLabel("Select by Customer ID"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));
        add(new JLabel("Phone Number"));
        add(new JLabel("Email"));

        sortCustomers(array);

        for (ShopData data : array) {
            Customer customer = ((Customer) data);
            JRadioButton select = new JRadioButton(customer.getID());
            group.add(select);
            select.addActionListener(radioListener);
            add(select);
            add(new JLabel(customer.getLastName()));
            add(new JLabel(customer.getFirstName()));
            add(new JLabel(customer.getPhone()));
            add(new JLabel(customer.getEmail()));
        }
    }

    private void sortCustomers(ArrayList<ShopData> array) {
        int i, j;
        for (i = 0; i < array.size(); i++) {
            for (j = i + 1; j < array.size(); j++) {
                Customer customer1 = ((Customer) array.get(i));
                Customer customer2 = ((Customer) array.get(j));
                if (customer1.getLastName().compareTo(customer2.getLastName()) > 0) {
                    Collections.swap(array, i, j);
                } else if (customer1.getLastName().compareTo(customer2.getLastName()) == 0) {
                    if (customer1.getFirstName().compareTo(customer2.getFirstName()) > 0) {
                        Collections.swap(array, i, j);
                    }
                }
            }
        }
    }

    private void setOrders(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return;
        }

        ButtonGroup group = new ButtonGroup();

        add(new JLabel("Select by Order Tag"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));

        sortOrders(array);

        for (ShopData data : array) {
            Order order = ((Order) data);
            Integer orderTag = order.getTag();
            JRadioButton select = new JRadioButton(orderTag.toString());
            group.add(select);
            select.addActionListener(radioListener);
            add(select);
            add(new JLabel(order.getCustomer().getLastName()));
            add(new JLabel(order.getCustomer().getFirstName()));
        }
    }

    private void sortOrders(ArrayList<ShopData> array) {
        int i, j;
        for (i = 0; i < array.size(); i++) {
            for (j = i + 1; j < array.size(); j++) {
                Order order1 = ((Order) array.get(i));
                Order order2 = ((Order) array.get(j));
                if (order1.getTag() > order2.getTag()) {
                    Collections.swap(array, i, j);
                }
            }
        }
    }

    void setContentListener(ActionListener radioListener) {
        this.radioListener = radioListener;
    }

    private void modifyLayout(int columnCount) {
        setLayout(new GridLayout(0, columnCount));
    }
}
