package databasegui;

import dataabstractions.ShopData;

import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class DatabaseGui {
    final protected int WINDOW_HEIGHT;
    final protected int WINDOW_WIDTH;
    final private WindowFrame WINDOW = new WindowFrame();
    final private PopupPane POPUP = new PopupPane();

    public DatabaseGui(int width, int height, ActionListener mainListener) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        WINDOW.initialize();
        WINDOW.setButtonListener(mainListener, POPUP);
        WINDOW.setContentListener(POPUP);
        WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        WINDOW.setVisible(true);
    }

    public void updateContent(ArrayList<ShopData> data) {
        WINDOW.setContent(data);
    }
}
