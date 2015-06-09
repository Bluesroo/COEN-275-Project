package databasegui.popup;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class PopupFrame extends JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();

        switch (action) {
            case "New Customer":
                System.out.println(action);
                break;
            case "New Order":
                System.out.println(action);
                break;
        }
    }
}
