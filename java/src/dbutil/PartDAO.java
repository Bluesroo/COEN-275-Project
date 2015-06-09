package dbutil;

import dataabstractions.Labor;
import dataabstractions.Part;
import dataabstractions.ShopData;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author David Obatake
 */
public class PartDAO {
    private static ArrayList<ShopData> partData;
    private static Connection conn;

    public static void setConnection(Connection conn) {
        PartDAO.conn = conn;
    }

    public static void setFromDB(int orderID) {
        String query = "SELECT * FROM parts WHERE o_id = ?";
        partData = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, orderID);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery(query);

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
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public static ArrayList<ShopData> getData() {
        return partData;
    }

    public static void insertData(ArrayList<ShopData> partList, int orderID) {
        String query = "INSERT INTO parts (parttype, partmanufacturer, price, partname, o_id) " +
                "VALUES (?,?,?,?,?)";

        try {
            for(ShopData sd : partList) {
                PreparedStatement ps = conn.prepareStatement(query);
                try {
                    Part part = (Part) sd;
                    ps.setString(1, "Part");
                    ps.setString(2, part.getManufacturer());
                } catch (Exception e) {
                    ps.setString(1, "Labor");
                    ps.setString(2, null);
                }

                ps.setBigDecimal(3, new BigDecimal(((Labor) sd).getPrice()));
                ps.setString(4, ((Labor) sd).getName());
                ps.setInt(5, orderID);
                ps.executeUpdate();
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}
