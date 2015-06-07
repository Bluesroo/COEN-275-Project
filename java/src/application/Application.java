package application;

import application.databasegui.DatabaseGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        ApplicationRunner app = new ApplicationRunner();
        app.run(JDBC_DRIVER, DB_URL, USER, PASS);
    }
}