package dbutil;

import dataabstractions.Labor;
import dataabstractions.Part;
import dataabstractions.ShopData;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Mugen on 6/7/15.
 */
public class PartDAO {
    private ArrayList<ShopData> partData = new ArrayList<>();

    public void setFromDB(Connection conn, int orderID) throws SQLException{
        String query = "SELECT * FROM orders WHERE o_id = " + orderID;
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        if(rs.next()) {
            Labor p = null;
            if(rs.getString("parttype").equals("Labor")) {
                p = new Labor();
            }
            else {
                p = new Part();
                ((Part) p).setManufacturer(rs.getString("partmanufacturer"));
            }
            p.setName(rs.getString("partname"));
            p.setPrice(rs.getBigDecimal("price").doubleValue());
            partData.add(p);
        }
    }

    public ArrayList<ShopData> getData() {
        return partData;
    }
}
