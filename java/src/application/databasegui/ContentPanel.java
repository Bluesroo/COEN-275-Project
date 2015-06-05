package application.databasegui;

import application.dataabstractions.Customer;
import application.dataabstractions.Labor;
import application.dataabstractions.Order;
import application.dataabstractions.Part;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

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

    public void setContent(Object array) {
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
            setSuccess = false;
            System.out.println("Trying to display invalid array type.");
        }

        if (setSuccess) {
            state = arrayClass;
        }
        System.out.println("Current display: " + state.toString());
    }

    private boolean setCustomers(Object array) {
        return true;
    }

    private boolean setLabor(Object array) {
        return true;
    }

    private boolean setOrders(Object array) {
        return true;
    }

    private boolean setParts(Object array) {
        return true;
    }

    private void setColumnCount(Object array) {

    }

    private void setRowCount(Object array) {

    }

    /* public void itemStateChanged(ItemEvent e) {
        Object src = e.getItemSelectable();
        int oTag = Integer.parseInt(((JCheckBox) src).getText());
        Customer temp = null;
        for (Order o : orders)
            if (o.getTag() == oTag)
                temp = o.getCustomer();

        if(e.getStateChange() == ItemEvent.DESELECTED){
            emailList.remove(temp);
        }
        else if (e.getStateChange() == ItemEvent.SELECTED){
            emailList.add(temp);
        }
    } */
}
