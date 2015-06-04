package application.databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel implements ActionListener {
    final private int COLUMN_COUNT;
    final private int ROW_COUNT;

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
}
