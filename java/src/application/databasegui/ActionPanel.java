package application.databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel {
    private JButton newCustomer = new JButton("New Customer");
    private JButton newRepair = new JButton("New Repair");
    private JButton notify = new JButton("Notify");
    private JButton search = new JButton("Search");

    ActionPanel() {
        setBackground(Color.RED);

        add(newCustomer);
        add(newRepair);
        add(notify);
        add(search);
    }

    void setActionBarListeners(ActionListener[] listeners) {
        newCustomer.addActionListener(listeners[0]);
        newRepair.addActionListener(listeners[1]);
        notify.addActionListener(listeners[2]);
        search.addActionListener(listeners[3]);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
