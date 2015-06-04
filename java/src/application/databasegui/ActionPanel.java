package application.databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel {


    ActionPanel(ColumnPanel columns, ContentPanel content) {
        setBackground(Color.RED);

        JButton newCustomer = new JButton("New Customer");
        JButton newRepair = new JButton("New Repair");
        JButton notify = new JButton("Notify");
        JButton search = new JButton("Search");

        newCustomer.addActionListener(content);
        newRepair.addActionListener(content);
        notify.addActionListener(content);
        search.addActionListener(content);

        add(newCustomer);
        add(newRepair);
        add(notify);
        add(search);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
