package application.databasegui;

import javax.swing.*;

/**
 * @author Joseph Pariseau
 */
public class WindowFrame extends JFrame {
    final private JPanel CONTAINER = new JPanel();

    WindowFrame() {
        setTitle("SCBS Repair Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void run() {
        CONTAINER.removeAll();

        ColumnPanel columns = new ColumnPanel();
        ContentPanel content = new ContentPanel();
        JScrollPane contentScroll = new JScrollPane();
        ActionPanel actions = new ActionPanel();

        CONTAINER.add(actions);
        CONTAINER.add(columns);
        CONTAINER.add(contentScroll);

        CONTAINER.setLayout(new BoxLayout(CONTAINER, BoxLayout.PAGE_AXIS));
        setContentPane(CONTAINER);
    }
}
