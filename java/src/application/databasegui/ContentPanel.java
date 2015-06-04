package application.databasegui;

import application.dataabstractions.Customer;
import application.dataabstractions.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel implements ActionListener, ItemListener {
    final private int COLUMN_COUNT;
    final private int ROW_COUNT;

    private ArrayList<Customer> emailList;
    private ArrayList<Order> orders;

    ContentPanel(int rowCount, int columnCount) {
        ROW_COUNT = rowCount;
        COLUMN_COUNT = columnCount;
        setBackground(Color.BLUE);
        setLayout(new GridLayout(0, COLUMN_COUNT));
        setContent();
    }

    private void setContent() {
        int j;
        for (int i = 0; i < ROW_COUNT; i++) {
            for (j = 0; j < COLUMN_COUNT; j++) {
                JLabel dataPoint = new JLabel("Data " + (i + 1) + "." + (j + 1));
                add(dataPoint);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        switch (action) {
            case "New Customer":
                System.out.println("New Customer");
                break;
            case "New Repair":
                System.out.println("New Repair");
                break;
            case "Notify":
                System.out.println("Notify");
                break;
            case "Search":
                System.out.println("Search");
                break;
        }
    }

    public void itemStateChanged(ItemEvent e) {
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
    }
}
