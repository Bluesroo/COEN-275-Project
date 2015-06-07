package databasegui;

import dataabstractions.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel {
    private int columnCount;
    private int rowCount;

    ContentPanel() {
        setBackground(Color.BLUE);
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
        System.out.println(rowCount);
        return true;
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
