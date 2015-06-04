package application.databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import application.dataabstractions.Customer;
import notification.AutoEmail;

/**
 * @author Joseph Pariseau
 */
public class ActionPanel extends JPanel implements ActionListener{

    private ArrayList<Customer> emailList;


    ActionPanel() {
        setBackground(Color.RED);

        JButton newCustomer = new JButton("New Customer");
        JButton newRepair = new JButton("New Repair");
        JButton notify = new JButton("Notify");
        JButton search = new JButton("Search");

        add(newCustomer);
        add(newRepair);
        add(notify);
        add(search);

        emailList = new ArrayList<>();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1280, 30);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void addToEmailList(Customer c){
        emailList.add(c);
        System.out.println("Customer added: " + c.getName());
    }

    public void removeFromEmailList(Customer c){
        for(Customer inList : emailList)
            if(inList.equals(c))
                emailList.remove(inList);
    }
}
