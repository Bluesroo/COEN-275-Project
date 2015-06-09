package dbutil;

import java.sql.*;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

    public static Customer getSingleData(int ID) throws SQLException {
        for (ShopData i : customerData) {
            Customer customer = (Customer) i;
            if (Integer.parseInt(customer.getID()) == ID) {
                return customer;
            }
        }
        return null;
    }


    public static ArrayList<ShopData> getData() {
        return customerData;
    }

    public static void insertData(Connection conn, Customer c) throws SQLException{
        Statement stmt = conn.createStatement();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String query = "INSERT INTO customers (lastname, firstname, email, phone, ext, dateadded) " +
                "VALUES (?,?,?,?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, c.getLastName());
        ps.setString(2, c.getFirstName());
        ps.setString(3, c.getEmail());
        ps.setString(4, c.getPhone());
        ps.setString(5, null);
        ps.setString(6, new Date().toString());
        ps.executeUpdate();
    }
}
