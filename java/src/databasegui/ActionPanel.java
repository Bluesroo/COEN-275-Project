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
    private JButton changeView = new JButton("Change View");
    private JButton notify = new JButton("Notify");
    //private JButton search = new JButton("Search");

    ActionPanel() {
        setBackground(Color.RED);

        add(newEntry);
        add(changeView);
        add(notify);
        //add(search);
    }

    void setActionBarListeners(ActionListener mainListener) {
        newEntry.addActionListener(mainListener);
        changeView.addActionListener(mainListener);
        notify.addActionListener(mainListener);
        //search.addActionListener(mainListener);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
