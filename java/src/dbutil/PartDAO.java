package dbutil;

import dataabstractions.Labor;
import dataabstractions.Part;
import dataabstractions.ShopData;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class PartDAO {
    private static ArrayList<ShopData> partData;

    public static void setFromDB(Connection conn, int orderID) throws SQLException {
        String query = "SELECT * FROM orders WHERE order_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, orderID);
        ResultSet rs = ps.executeQuery(query);
        partData = new ArrayList<>();

        if (rs.next()) {
            Labor p;
            if (rs.getString("parttype").equals("Labor")) {
                p = new Labor();
            } else {
                p = new Part();
                ((Part) p).setManufacturer(rs.getString("partmanufacturer"));
            }
            p.setName(rs.getString("partname"));
            p.setPrice(rs.getBigDecimal("price").doubleValue());
            partData.add(p);
        }
    }

    public static ArrayList<ShopData> getData() {
        return partData;
    }

    public static void insertData(Connection conn, ArrayList<Labor> partList, int orderID) {
        String query = "INSERT INTO parts (parttype, partmanufacturer, price, partname, o_id) " +
                "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
        } catch (SQLException se) {
            se.printStackTrace();
        }

    }

}
