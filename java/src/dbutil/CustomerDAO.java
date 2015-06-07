package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataabstractions.Customer;
import dataabstractions.ShopData;

/**
 * Created by Mugen on 6/7/15.
 */
public class CustomerDAO {

    Statement stmt;

    public ArrayList<ShopData> getAllCustomers(Connection conn) throws SQLException{
        ArrayList<ShopData> cList = new ArrayList<>();
        String query = "SELECT * FROM customers";
        String orderQuery = "SELECT * FROM orders WHERE ";
        ResultSet rs = null;
        try {
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                Customer c = new Customer();
                c.setFirstName(rs.getString("firstname"));
                c.setLastname(rs.getString("lastname"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                cList.add(c);
            }

        } finally {
            rs.close();
            stmt.close();
        }

        return cList;
    }
}
