package databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel {
    private JButton newCustomer = new JButton("New Customer");
    private JButton newOrder = new JButton("New Order");
    private JButton viewCustomers = new JButton("View Customers");
    private JButton viewOrders = new JButton("View Orders");
    private JButton notify = new JButton("Notify");

    ActionPanel() {
        setBackground(Color.RED);

        add(newCustomer);
        add(newOrder);
        add(viewCustomers);
        add(viewOrders);
        add(notify);
    }

    void setActionBarListener(ActionListener mainListener) {
        newCustomer.addActionListener(mainListener);
        newOrder.addActionListener(mainListener);
        viewCustomers.addActionListener(mainListener);
        viewOrders.addActionListener(mainListener);
        notify.addActionListener(mainListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
