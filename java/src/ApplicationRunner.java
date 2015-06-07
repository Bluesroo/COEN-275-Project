import dataabstractions.Customer;
import dataabstractions.ShopData;
import databasegui.DatabaseGui;
import dbutil.CustomerDAO;

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
    void run(String jdbcDriver, String dbUrl, String user, String pass) {
        Connection conn = null;
        Statement sqlStatement = null;
        DatabaseGui gui = new DatabaseGui(1280, 720, this);

        try {
            //Connects to the database and prepares to issue a statement
            conn = DriverManager.getConnection(dbUrl, user, pass);
            sqlStatement = conn.createStatement();
            Class.forName(jdbcDriver);
            CustomerDAO example = new CustomerDAO();
            example.setFromDB(conn);
            ArrayList<ShopData> customerData = CustomerDAO.getData();
            Customer test = (Customer) customerData.get(0);
            System.out.println(test.getFirstName());
        }

        //Handle exceptions for JDBC
        catch (Exception e) {
            e.printStackTrace();
        }

        //Finally block used to close resources
        finally {
            try {
                if (sqlStatement != null) {
                    sqlStatement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        String action = event.getActionCommand();

        if (action.equals("Notify")) {
            System.out.println("Notify");
        }
    }
}
