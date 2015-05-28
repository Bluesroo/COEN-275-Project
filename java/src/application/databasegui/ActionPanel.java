package application.databasegui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel {

    ActionPanel() {
        setBackground(Color.RED);

        JButton newCustomer = new JButton("New Customer");
        JButton newRepair = new JButton("New Repair");
        JButton notify = new JButton("Notify");
        JButton search = new JButton("Search");

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
