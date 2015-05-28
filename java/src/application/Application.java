package application;

import application.databasegui.DatabaseGui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Main entry point to the database
 *
 * @author Joseph pariseau
 */
public class Application {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bikeshop";
    static final String USER = User.username();
    static final String PASS = User.password();

    public static void main(String[] args) {
        Connection conn = null;
        Statement sqlStatement = null;

        try {
            //Connects to the database and prepares to issue a statement
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            sqlStatement = conn.createStatement();
            Class.forName(JDBC_DRIVER);
        }

        //Handle exceptions for JDBC
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //Finally block used to close resources
        finally {
            try {
                if (sqlStatement != null) {
                    sqlStatement.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            }
            catch (SQLException se) {
                se.printStackTrace();
            }
        }

        DatabaseGui test = new DatabaseGui(1280, 720);
        test.run();
    }
}