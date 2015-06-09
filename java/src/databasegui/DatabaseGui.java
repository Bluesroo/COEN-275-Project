package databasegui;

import com.sun.org.apache.bcel.internal.generic.POP;
import dataabstractions.ShopData;
import databasegui.popup.PopupFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class DatabaseGui implements ActionListener {
    final protected int WINDOW_HEIGHT;
    final protected int WINDOW_WIDTH;
    final private WindowFrame WINDOW = new WindowFrame();
    final private PopupFrame POPUP = new PopupFrame();
    private String selectedRow;

    public DatabaseGui(int width, int height, ActionListener mainListener) {
        WINDOW_WIDTH = width;
        WINDOW_HEIGHT = height;
        WINDOW.initialize();
        WINDOW.setButtonListener(mainListener, POPUP);
        WINDOW.setContentListener(this);
        WINDOW.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        WINDOW.setVisible(true);
    }

    public void updateContent(ArrayList<ShopData> data) {
        WINDOW.setContent(data);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
    }
}
