package dbutil;

import dataabstractions.Labor;
import dataabstractions.Order;
import dataabstractions.Part;
import dataabstractions.ShopData;

import java.lang.reflect.Parameter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class OrderDAO {

    private static ArrayList<ShopData> orderData = new ArrayList<>();

    public static void setFromDB(Connection conn) throws SQLException{
        String query = "SELECT * FROM orders";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()) {
            Order o = new Order(rs.getInt("order_id"));
            PartDAO.setFromDB(conn, o.getTag());
            int numItems = PartDAO.getData().size();
            for(int i = 0; i < numItems; i++)
                o.addItem((Labor) PartDAO.getData().get(i));
            o.setCustomer(CustomerDAO.getSingleFromDB(conn, o.getTag()));
            o.setDate(rs.getDate("date"));
            orderData.add(o);
        }
    }

    public static ArrayList<Order> getSingleFromDB(Connection conn, int ID) throws SQLException{
        ArrayList<Order> customerOrders = new ArrayList<>();
        String query = "SELECT * FROM orders " +
                "WHERE customer_id = " + ID + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()) {
            Order o = new Order(rs.getInt("order_id"));
            PartDAO.setFromDB(conn, o.getTag());
            int numItems = PartDAO.getData().size();
            for(int i = 0; i < numItems; i++)
                o.addItem((Labor) PartDAO.getData().get(i));
            o.setCustomer(CustomerDAO.getSingleFromDB(conn, o.getTag()));
            o.setDate(rs.getDate("date"));
            customerOrders.add(o);
        }
        return customerOrders;
    }

    public static ArrayList<ShopData> getData() {
        return orderData;
    }
}
