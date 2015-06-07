package dbutil;

import dataabstractions.Labor;
import dataabstractions.Order;
import dataabstractions.ShopData;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author David Obatake
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
            Order o = new Order(rs.getInt("order_id"));
            PartDAO p = new PartDAO();
            p.setFromDB(conn, o.getTag());
            int numItems = p.getData().size();
            for(int i = 0; i < numItems; i++)
                o.addItem((Labor) p.getData().get(i));
            orderData.add(o);
        }
    }
    public static ArrayList<ShopData> getData() {
        return orderData;
    }
}
