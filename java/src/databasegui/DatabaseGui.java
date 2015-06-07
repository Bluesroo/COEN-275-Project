package databasegui;

import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class DatabaseGui{
    final int WINDOW_HEIGHT;
    final int WINDOW_WIDTH;
    private final WindowFrame WINDOW = new WindowFrame();
    private int fakeArray [];

    public DatabaseGui(int width, int height, ActionListener mainListener) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        WINDOW.initialize();
        WINDOW.setActionListeners(mainListener);
        WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        WINDOW.setVisible(true);
    }

    public void updateContent () {
        WINDOW.setContent(fakeArray);
    }
}
