package databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel {
    private JButton newEntry = new JButton("New Entry");
    private JButton viewCustomers = new JButton("View Customers");
    private JButton viewOrders = new JButton("View Orders");
    private JButton notify = new JButton("Notify");
    //private JButton search = new JButton("Search");

    ActionPanel() {
        setBackground(Color.RED);

        add(newEntry);
        add(viewCustomers);
        add(viewOrders);
        add(notify);
        //add(search);
    }

    void setActionBarListeners(ActionListener mainListener) {
        newEntry.addActionListener(mainListener);
        viewCustomers.addActionListener(mainListener);
        viewOrders.addActionListener(mainListener);
        notify.addActionListener(mainListener);
        //search.addActionListener(mainListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
