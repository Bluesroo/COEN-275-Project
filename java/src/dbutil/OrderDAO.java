package dbutil;

import dataabstractions.Labor;
import dataabstractions.Order;
import dataabstractions.Part;
import dataabstractions.ShopData;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author David Obatake
 */
public class OrderDAO {

    private static ArrayList<ShopData> orderData;

    public static void setFromDB(Connection conn) throws SQLException {
        String query = "SELECT * FROM orders";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        orderData = new ArrayList<>();

        while (rs.next()) {
            Order o = new Order(rs.getInt("order_id"));
            //PartDAO.setFromDB(conn, o.getTag());
            //int numItems = PartDAO.getData().size();
            //for (int i = 0; i < numItems; i++)
            //    o.addItem((Labor) PartDAO.getData().get(i));
            o.setCustomer(CustomerDAO.getSingleData(o.getTag()));
            //o.setDate(rs.getDate("date"));
            orderData.add(o);
        }
    }

    public static Order getSingleData(int ID) throws SQLException {
        for (ShopData i : orderData) {
            Order order = (Order) i;
            if (order.getTag() == ID) {
                return order;
            }
        }
        return null;
    }

    public static ArrayList<ShopData> getData() {
        return orderData;
    }

    public static void insertData(Connection conn, Order o) throws SQLException{
        Statement stmt = conn.createStatement();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String query = "INSERT INTO orders (order_id, customer_id, date) " +
                "VALUES (?,?,?);";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, Integer.toString(o.getTag()));
        ps.setString(2, o.getCustomer().getID());
        ps.setString(3, new Date().toString());
        ps.executeUpdate();
    }
}
