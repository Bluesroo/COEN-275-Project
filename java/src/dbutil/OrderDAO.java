package dbutil;

import dataabstractions.Order;
import dataabstractions.ShopData;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Mugen on 6/7/15.
 */
public class OrderDAO {
    Statement stmt;
    private static ArrayList<ShopData> orderData = new ArrayList<>();

    public void setFromDB(Connection conn) throws SQLException{
        ArrayList<ShopData> oList = new ArrayList<>();
        String query = "SELECT * FROM orders";
        ResultSet rs = null;
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        if(rs.next()) {
            Order o = new Order();
            o.setTag
            orderData.add(o);
        }
    }
    public static ArrayList<ShopData> getData() {
        return orderData;
    }
}
