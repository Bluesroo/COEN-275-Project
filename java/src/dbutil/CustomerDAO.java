package dbutil;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;

import dataabstractions.Customer;
import dataabstractions.ShopData;

/**
 * @author Joseph Pariseau
 */
public class CustomerDAO {

    private static ArrayList<ShopData> customerData;
    private static Connection conn;

    public static void setConnection(Connection conn) {
        CustomerDAO.conn = conn;
    }

    public static void setFromDB() {
        String query = "SELECT * FROM customers";
        customerData = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Customer c = new Customer();
                c.setFirstName(rs.getString("firstname"));
                c.setLastName(rs.getString("lastname"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setID(rs.getString("ID"));
                customerData.add(c);
            }
        } catch (SQLException se) {
            se.printStackTrace();
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

    public static void insertData(Customer c) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String query = "INSERT INTO customers (lastname, firstname, email, phone, ext, dateadded) " +
                "VALUES (?,?,?,?,?,?);";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, c.getLastName());
            ps.setString(2, c.getFirstName());
            ps.setString(3, c.getEmail());
            ps.setString(4, c.getPhone());
            ps.setString(5, null);
            ps.setString(6, df.parse(new Date().toString()).toString());
            ps.executeUpdate();
        } catch (SQLException | ParseException se){
            se.printStackTrace();
        }
    }
}
