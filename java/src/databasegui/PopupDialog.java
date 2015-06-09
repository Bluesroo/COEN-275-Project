package databasegui;

import dataabstractions.Customer;
import dataabstractions.Order;
import dbutil.CustomerDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Joseph Pariseau
 */
public class PopupDialog {

    private static Customer lastAddedCustomer;
    private static Order lastAddedOrder;
    private static String selectedRow;

    private PopupDialog() {
    }

    public static void createAndShowDialog(final String action){
        final JDialog popup = new JDialog();
        popup.setLayout(new BorderLayout());

        JPanel contentPanel = setContent(action);

        Box content = Box.createHorizontalBox();
        content.add(Box.createHorizontalGlue());
        content.add(contentPanel, BorderLayout.CENTER);
        content.add(Box.createHorizontalGlue());

        popup.add(content);
        popup.pack();
        popup.setLocationRelativeTo(null);
        popup.setVisible(true);


    }

    private static JPanel setContent(String action) {
        switch (action) {
            case "New Customer":
                return setNewCustomer();
            case "New Order":
                return setNewOrder();
        }
        return null;
    }

    public static void setSelectedRow(String row) {
        selectedRow = row;
    }

    private static JPanel setNewCustomer() {
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

        JButton addButton = new JButton("Add Customer");

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
        newCustomerPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lastAddedCustomer = new Customer(lastName.getText(), firstName.getText(), email.getText(), phone.getText());
                CustomerDAO.insertData(lastAddedCustomer);
            }
        });

        return newCustomerPanel;
    }

    private static JPanel setNewOrder() {
        JPanel newOrderPanel = new JPanel();

        if (selectedRow == null) {
            JLabel warning = new JLabel("You need to select a customer first.");
            newOrderPanel.add(warning);
            return newOrderPanel;
        }

        newOrderPanel.setLayout(new GridLayout(0, 2));

        JLabel firstNameLabel = new JLabel("First Name: ");
        JTextField firstName = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name: ");
        JTextField lastName = new JTextField(20);

        newOrderPanel.add(firstNameLabel);
        newOrderPanel.add(firstName);
        newOrderPanel.add(lastNameLabel);
        newOrderPanel.add(lastName);

        lastAddedOrder = new Order();

        try {
            lastAddedOrder.setCustomer(CustomerDAO.getSingleData(Integer.parseInt(selectedRow)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        selectedRow = null;
        return newOrderPanel;
    }
}
