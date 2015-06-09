package databasegui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class PopupPane extends JOptionPane implements ActionListener {

    public PopupPane() {
        setPreferredSize(new Dimension(600, 200));
    }

    void setContent(String action) {
        switch (action) {
            case "New Customer":
                showConfirmDialog(null, setNewCustomer(), "Enter the new customer information", JOptionPane.OK_CANCEL_OPTION);
                break;
            case "New Order":
                showConfirmDialog(null, setNewOrder(), "Enter the new customer information", JOptionPane.OK_CANCEL_OPTION);
                break;
        }
    }

    private JPanel setNewCustomer() {
        JPanel newCustomerPanel = new JPanel();
        newCustomerPanel.setLayout(new GridLayout(0, 2));

        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField firstName = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField lastName = new JTextField(20);
        JLabel emailLabel = new JLabel("Email Address: ");
        JTextField email = new JTextField(20);
        JLabel phoneLabel = new JLabel("Phone Number: ");
        JTextField phone = new JTextField(10);
        JLabel extensionLabel = new JLabel("ext.: ");
        JTextField extension = new JTextField(10);

        newCustomerPanel.add(firstNameLabel);
        newCustomerPanel.add(firstName);
        newCustomerPanel.add(lastNameLabel);
        newCustomerPanel.add(lastName);
        newCustomerPanel.add(emailLabel);
        newCustomerPanel.add(email);
        newCustomerPanel.add(phoneLabel);
        newCustomerPanel.add(phone);
        newCustomerPanel.add(extensionLabel);
        newCustomerPanel.add(extension);

        return newCustomerPanel;
    }

    private JPanel setNewOrder() {
        JPanel newOrderPanel = new JPanel();
        newOrderPanel.setLayout(new GridLayout(0, 2));

        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField firstName = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField lastName = new JTextField(20);

        newOrderPanel.add(firstNameLabel);
        newOrderPanel.add(firstName);
        newOrderPanel.add(lastNameLabel);
        newOrderPanel.add(lastName);

        return newOrderPanel;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();

        switch (action) {
            case "New Customer":
            case "New Order":
                setContent(action);
                break;
            case "Add":
                break;
        }
    }
}
