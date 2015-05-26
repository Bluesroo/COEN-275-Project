package application.databasegui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class TestGui implements ActionListener {
    private final int WINDOW_HEIGHT;
    private final int WINDOW_WIDTH;
    private final JFrame WINDOW = new JFrame();
    private final JPanel CONTAINER = new JPanel();
    private int columnCount = 7;
    private int rowCount = 50;

    public TestGui(int width, int height) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        WINDOW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        WINDOW.setTitle("SCBS Repair Tracker");
        CONTAINER.setLayout(new BoxLayout(CONTAINER, BoxLayout.PAGE_AXIS));
    }

    public void run() {
        Border black = BorderFactory.createLineBorder(Color.BLACK, 3);

        // Make the main panels and their dimensions
        JPanel actions = new JPanel();
        actions.setBackground(Color.RED);
        //actions.setBorder(black);

        JPanel columns = new JPanel();
        columns.setBackground(Color.GREEN);
        columns.setLayout(new GridLayout(1, 0));
        columns.setBorder(black);
        setColumns(columns);

        JPanel content = new JPanel();
        content.setBackground(Color.BLUE);
        content.setBorder(black);
        content.setLayout(new GridLayout(0, columnCount));
        setContent(content);

        JScrollPane scrollPane = new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Make main action buttons
        JButton newCustomer = new JButton("New Customer");
        JButton newRepair = new JButton("New Repair");
        JButton notify = new JButton("Notify");
        JButton search = new JButton("Search");

        // Add buttons to action panel
        actions.add(newCustomer);
        actions.add(newRepair);
        actions.add(notify);
        actions.add(search);

        // Add panels to the CONTAINER
        CONTAINER.add(actions);
        CONTAINER.add(columns);
        CONTAINER.add(scrollPane);

        // Set the CONTAINER as the main panel and display ti
        WINDOW.setContentPane(CONTAINER);
        //WINDOW.pack();
        WINDOW.setVisible(true);
    }

    private void setColumns(JPanel columnsPanel) {
        for (int i = 0; i < columnCount; i++) {
            JLabel columnLabel = new JLabel("Column " + (i + 1));
            //columnLabel.setVerticalAlignment(SwingConstants.TOP);
            columnsPanel.add(columnLabel);
        }
    }

    private void setContent(JPanel contentPanel) {
        int j;
        for (int i = 0; i < rowCount; i++) {
            for (j = 0; j < columnCount; j++) {
                JLabel dataPoint = new JLabel("Data " + (i + 1) + "." + (j + 1));
                //dataPoint.setVerticalAlignment(SwingConstants.TOP);
                contentPanel.add(dataPoint);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

    }
}
