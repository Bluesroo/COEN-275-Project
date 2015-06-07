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

    void setActionBarListeners(ActionListener mainListener) {
        newCustomer.addActionListener(mainListener);
        newRepair.addActionListener(mainListener);
        notify.addActionListener(mainListener);
        search.addActionListener(mainListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
