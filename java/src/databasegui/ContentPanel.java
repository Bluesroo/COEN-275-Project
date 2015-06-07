package databasegui;

import dataabstractions.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel {
    private int columnCount = 10;
    private int rowCount = 0;

    ContentPanel() {
        setBackground(Color.BLUE);
        setLayout(new GridLayout(0, columnCount));
    }

    boolean setContent(ArrayList<ShopData> array) {
        removeAll();

        boolean setSuccess;

        if (array.get(0) instanceof Customer) {
            setSuccess = setCustomers(array);
        } else if (array.get(0) instanceof Order) {
            setSuccess = setOrders(array);
        } else if (array.get(0) instanceof Part) {
            setSuccess = setParts(array);
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

        columnCount = 4;
        modifyLayout();

        add(new JLabel("Last Name"));
        add(new JLabel("First Name"));
        add(new JLabel("Phone Number"));
        add(new JLabel("Email"));

        for (int i = 0; i < array.size(); i++) {
            Customer customer = ((Customer) array.get(i));
            add(new JLabel(customer.getLastname()));
            add(new JLabel(customer.getFirstName()));
            add(new JLabel(customer.getPhone()));
            add(new JLabel(customer.getEmail()));
        }
        return true;
    }

    private boolean setOrders(Object array) {
        return false;
    }

    private boolean setParts(Object array) {
        return true;
    }

    private void modifyLayout() {
        setLayout(new GridLayout(0, columnCount));
    }
}
