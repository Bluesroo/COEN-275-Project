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

    private static ArrayList<ShopData> customerData = new ArrayList<>();

    public void setFromDB(Connection conn) throws SQLException {
        String query = "SELECT * FROM customers";
        ResultSet rs;
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        if (rs.next()) {
            Customer c = new Customer();
            c.setFirstName(rs.getString("firstname"));
            c.setLastname(rs.getString("lastname"));
            c.setEmail(rs.getString("email"));
            c.setPhone(rs.getString("phone"));
            customerData.add(c);
        }
    }

    public static ArrayList<ShopData> getData() {
        return customerData;
    }
}
