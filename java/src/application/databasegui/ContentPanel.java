package application.databasegui;

import application.dataabstractions.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ContentPanel extends JPanel implements ItemListener{
    final private int COLUMN_COUNT;
    final private int ROW_COUNT;
    // @TODO need to grab orders to populate ContentPanel
    private ArrayList<Order> orders;
    private PanelController controller;

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
            Order current = new Order();
            //Order current = orders.get(i);
            for (j = 0; j < COLUMN_COUNT; j++) {
                if(j == 0){
                    JCheckBox select = new JCheckBox(Integer.toString(current.getTag()));
                    select.setSelected(false);
                    select.addItemListener(this);
                    add(select);
                }
                else {
                    JLabel dataPoint = new JLabel("Data " + (i + 1) + "." + (j + 1));
                    add(dataPoint);
                }
            }
        }
    }

    public void setController(PanelController control){
        this.controller = control;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Object src = e.getItemSelectable();
        int oTag = Integer.parseInt(((JCheckBox) src).getText());
        Customer temp = null;
        for (Order o : orders)
            if (o.getTag() == oTag)
                temp = o.getCustomer();

        if(e.getStateChange() == ItemEvent.DESELECTED){
            controller.removeCustomer(temp);
        }
        else if (e.getStateChange() == ItemEvent.SELECTED){
            controller.copyCustomer(temp);
        }
    }
}
