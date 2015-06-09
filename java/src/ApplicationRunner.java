import dataabstractions.ShopData;
import databasegui.DatabaseGui;
import databasegui.PopupDialog;
import dbutil.CustomerDAO;
import dbutil.OrderDAO;
import dbutil.PartDAO;
import notification.AutoEmail;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Joseph Pariseau
 */
public class ApplicationRunner implements ActionListener {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bikeshop";
    static final String USER = User.username();
    static final String PASS = User.password();
    private Connection conn;

    DatabaseGui gui = new DatabaseGui(1280, 720, this);

    void run() {
        Statement sqlStatement = null;

        try {
            //Connects to the database and prepares to issue a statement
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            CustomerDAO.setConnection(conn);
            OrderDAO.setConnection(conn);
            PartDAO.setConnection(conn);
            Class.forName(JDBC_DRIVER);

            ArrayList<ShopData> content = returnDAOData("Customer");
            gui.updateContent(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<ShopData> returnDAOData(String DAO) throws SQLException {
        switch (DAO) {
            case "Customer":
                CustomerDAO.setFromDB();
                System.out.println(DAO);
                return CustomerDAO.getData();
            case "Order":
                OrderDAO.setFromDB();
                System.out.println(DAO);
                return OrderDAO.getData();
            default:
                System.out.println("Not a valid action.");
                break;
        }
        return null;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();
        ArrayList<ShopData> content;
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            switch (action) {
                case "Notify":
                    AutoEmail.generateAndSendEmail();
                    System.out.println(action);
                    break;
                case "View Customers":
                    content = returnDAOData("Customer");
                    gui.updateContent(content);
                    System.out.println(action);
                    break;
                case "View Orders":
                    content = returnDAOData("Order");
                    gui.updateContent(content);
                    System.out.println(action);
                    break;
                case "New Customer":
                case "New Order":
                    PopupDialog.createAndShowDialog(action);
                    break;
                default:
                    PopupDialog.setSelectedRow(action);
                    AutoEmail.setSelectedRow(action);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
