package dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.dataabstractions.Customer;

/**
 * Created by Mugen on 6/7/15.
 */
public class CustomerDAO {

    public ArrayList<Customer> getAllCustomers(Connection conn) throws SQLException{
        ArrayList<Customer> cList = new ArrayList<>();
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
        }

        return cList;
    }
}
