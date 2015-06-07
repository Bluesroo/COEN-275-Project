package databasegui;

import dataabstractions.Customer;
import dataabstractions.Labor;
import dataabstractions.Order;
import dataabstractions.Part;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel {
    private int columnCount;
    private int rowCount;
    private Class state;

    ContentPanel() {
        setBackground(Color.BLUE);
        setLayout(new GridLayout(0, columnCount));
    }

    boolean setContent(Object array) {
        removeAll();

        Class arrayClass = array.getClass();
        boolean setSuccess;

        if (arrayClass.equals(Customer.class)) {
            setSuccess = setCustomers(array);
        } else if (arrayClass.equals(Labor.class)) {
            setSuccess = setLabor(array);
        } else if (arrayClass.equals(Order.class)) {
            setSuccess = setOrders(array);
        } else if (arrayClass.equals(Part.class)) {
            setSuccess = setParts(array);
        } else {
            System.out.println("Trying to display invalid array type.");
            setSuccess = false;
        }

        if (setSuccess) {
            state = arrayClass;
        }

        System.out.println("Current display: " + state.toString());
        return setSuccess;

    }

    private boolean setCustomers(Object array) {
        System.out.println(rowCount);
        return true;
    }

    private boolean setLabor(Object array) {
        return false;
    }

    private boolean setOrders(Object array) {
        return false;
    }

    private boolean setParts(Object array) {
        return true;
    }

    private void setColumnCount(Object array) {
        columnCount = 10;
        System.out.println(array);
        System.out.println(columnCount);
    }

    private void setRowCount(Object array) {
        rowCount = 10;
        System.out.println(array);
        System.out.println(rowCount);
    }
}
