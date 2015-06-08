package databasegui;

import dataabstractions.ShopData;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class WindowFrame extends JFrame {
    final private JPanel CONTAINER = new JPanel();
    final protected ContentPanel CONTENT = new ContentPanel();
    final protected JScrollPane CONTENT_SCROLL = new JScrollPane(CONTENT);
    final protected ActionPanel ACTION_FRAME = new ActionPanel();

    WindowFrame() {
        setTitle("SCBS Repair Tracker");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initialize() {
        CONTAINER.removeAll();

        CONTAINER.add(ACTION_FRAME);
        CONTAINER.add(CONTENT_SCROLL);

        CONTAINER.setLayout(new BoxLayout(CONTAINER, BoxLayout.PAGE_AXIS));
        setContentPane(CONTAINER);
    }

    void setActionListeners(ActionListener mainListener) {
        ACTION_FRAME.setActionBarListeners(mainListener);
    }

    public void setContent(ArrayList<ShopData> data) {
        CONTENT.setContent(data);
        validate();
    }
}
