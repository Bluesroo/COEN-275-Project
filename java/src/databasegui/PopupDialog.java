package databasegui;

import dataabstractions.Customer;
import dataabstractions.Labor;
import dataabstractions.Order;
import dataabstractions.Part;
import dbutil.CustomerDAO;
import dbutil.OrderDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class PopupDialog {

    private static Customer lastAddedCustomer;
    private static Order lastAddedOrder;
    private static String selectedRow;
    private static String currentState;
    final private static JDialog popup = new JDialog();


    private PopupDialog() {
    }

    public static void createAndShowDialog(final String action){
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

    public static void setCurrentState(String state) {
        currentState = state;
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

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                System.out.println(event.getActionCommand());
                CustomerDAO.insertData(new Customer(lastName.getText(), firstName.getText(), email.getText(), phone.getText()));
                popup.dispose();
            }
        });

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

        return newCustomerPanel;
    }

    private static JPanel setNewOrder() {
        JPanel newOrderPanel = new JPanel();
        String [] partOptions = {"Labor", "Part"};

        if (selectedRow == null || currentState.compareTo("Customer") != 0) {
            JLabel warning = new JLabel("You need to select a customer first.");
            newOrderPanel.add(warning);
            return newOrderPanel;
        }

        newOrderPanel.setLayout(new GridLayout(0, 2));

        JButton anotherPart = new JButton("Add Part");
        anotherPart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                JLabel partNameLabel = new JLabel("Part name: ");
                JTextField partName = new JTextField(20);
                JLabel partManufacturerLabel = new JLabel("Part manufacturer: ");
                JTextField partManufacturer = new JTextField(20);
                JLabel priceLabel = new JLabel("Price: ");
                JTextField price = new JTextField(10);
                JLabel typeChooseLabel = new JLabel("Type: ");
                JComboBox typeChoose = new JComboBox(partOptions);

                newOrderPanel.add(typeChooseLabel);
                newOrderPanel.add(typeChoose);
                newOrderPanel.add(partNameLabel);
                newOrderPanel.add(partName);
                newOrderPanel.add(partManufacturerLabel);
                newOrderPanel.add(partManufacturer);
                newOrderPanel.add(priceLabel);
                newOrderPanel.add(price);
                newOrderPanel.validate();
                popup.validate();
                popup.pack();
            }
        });
        newOrderPanel.add(anotherPart);

        JButton addButton = new JButton("Add Order");
        newOrderPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                lastAddedOrder = new Order();
                String type = "Labor";

                Component [] compontentList = newOrderPanel.getComponents();
                for (int i = 1; i < compontentList.length; i++) {
                    Component c = compontentList[i];
                    if (c instanceof JComboBox) {
                        JComboBox jc = (JComboBox) c;
                        type = (String) jc.getSelectedItem();
                    }
                    i++;
                    if (type.matches("Labor")) {
                        i += 3;
                        String laborName = ((JTextField) compontentList[i]).getText();
                        i += 4;
                        double price = Double.parseDouble(((JTextField) compontentList[i]).getText());
                        lastAddedOrder.addItem(new Labor(laborName, price));
                    }
                    else {
                        i += 3;
                        String partName = ((JTextField) compontentList[i]).getText();
                        i += 2;
                        String partManufacturer = ((JTextField) compontentList[i]).getText();
                        i += 2;
                        double price = Double.parseDouble(((JTextField) compontentList[i]).getText());
                        lastAddedOrder.addItem(new Part(partName, price, partManufacturer));
                    }
                }

                lastAddedOrder.setCustomer(CustomerDAO.getSingleData(Integer.parseInt(selectedRow)));
                System.out.println(lastAddedOrder.getItems().size());
                OrderDAO.insertData(lastAddedOrder);
                selectedRow = null;
            }
        });

        return newOrderPanel;
    }
}
