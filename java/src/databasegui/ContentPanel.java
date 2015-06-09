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

    void setContent(ArrayList<ShopData> array) {
        removeAll();

        if (array.get(0) instanceof Customer) {
            modifyLayout(5);
            setCustomers(array);
        } else if (array.get(0) instanceof Order) {
            setOrders(array);
            modifyLayout(4);
        } else {
            System.out.println("Trying to display invalid array type.");
        }
    }

    private void setCustomers(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return;
        }

        ButtonGroup group = new ButtonGroup();

        add(new JLabel("Select"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));
        add(new JLabel("Phone Number"));
        add(new JLabel("Email"));

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

    private void setOrders(ArrayList<ShopData> array) {
        if (array.size() < 1) {
            return;
        }

        ButtonGroup group = new ButtonGroup();

        add(new JLabel("Select"));
        add(new JLabel("Order Tag"));
        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));

        for (ShopData data : array) {
            Order order = ((Order) data);
            Integer orderTag = order.getTag();
            JRadioButton select = new JRadioButton(orderTag.toString());
            group.add(select);
            select.addActionListener(radioListener);
            add(select);
            add(new JLabel(orderTag.toString()));
            add(new JLabel(order.getCustomer().getLastName()));
            add(new JLabel(order.getCustomer().getFirstName()));
        }
    }

    void setContentListener(ActionListener radioListener) {
        this.radioListener = radioListener;
    }

    private void modifyLayout(int columnCount) {
        setLayout(new GridLayout(0, columnCount));
    }
}
