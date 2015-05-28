package application.databasegui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Joseph Pariseau
 */
public class ColumnPanel extends JPanel {
    final private int COLUMN_COUNT;

    ColumnPanel(int columnCount) {
        COLUMN_COUNT = columnCount;
        setBackground(Color.GREEN);
        setLayout(new GridLayout(1, 0));
        setColumns();
    }

    private void setColumns() {
        for (int i = 0; i < COLUMN_COUNT; i++) {
            JLabel columnLabel = new JLabel("Column " + (i + 1));
            add(columnLabel);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }
}
