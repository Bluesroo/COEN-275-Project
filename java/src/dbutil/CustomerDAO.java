package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataabstractions.Customer;
import dataabstractions.ShopData;

/**
 * @author Joseph Pariseau
 */
public class CustomerDAO {

    private static ArrayList<ShopData> customerData;

    public static void setFromDB(Connection conn) throws SQLException {
        String query = "SELECT * FROM customers";
        ResultSet rs;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        customerData = new ArrayList<>();

        while (rs.next()) {
            Customer c = new Customer();
            c.setFirstName(rs.getString("firstname"));
            c.setLastName(rs.getString("lastname"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            c.setID(rs.getString("ID"));
            customerData.add(c);
        }
    }

    public static Customer getSingleFromDB(Connection conn, int ID) throws SQLException {
        String query = "SELECT * FROM customers " +
                "INNER JOIN orders " +
                "ON orders.customer_id = customers.ID " +
                "WHERE orders.order_id = " + ID + ";";
        ResultSet rs;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        Customer c = new Customer();
        if (rs.next()) {
            c.setFirstName(rs.getString("firstname"));
            c.setLastName(rs.getString("lastname"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
        }
        return c;
    }


    public static ArrayList<ShopData> getData() {
        return customerData;
    }
}
