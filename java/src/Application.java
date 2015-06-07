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