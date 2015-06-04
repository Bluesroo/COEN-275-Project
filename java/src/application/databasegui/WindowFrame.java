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

    public void run(int rowCount, int columnCount) {
        CONTAINER.removeAll();

        ColumnPanel columns = new ColumnPanel(columnCount);
        ContentPanel content = new ContentPanel(rowCount, columnCount);
        JScrollPane contentScroll = new JScrollPane(content);
        ActionPanel actions = new ActionPanel(columns, content);

        PanelController controller = new PanelController();
        controller.setActionPanel(actions);
        controller.setContentPanel(content);
        content.setController(controller);

        CONTAINER.add(actions);
        CONTAINER.add(columns);
        CONTAINER.add(contentScroll);

        CONTAINER.setLayout(new BoxLayout(CONTAINER, BoxLayout.PAGE_AXIS));
        setContentPane(CONTAINER);
    }
}
