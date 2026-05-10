package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database URL (change database name if needed)
    private static final String URL = "jdbc:mysql://localhost:3306/chatbotfiles";

    // MySQL username
    private static final String USER = "root";

    // MySQL password (change if you set one)
    private static final String PASSWORD = "root";

    private static Connection con = null;

    // Method to get database connection
    public static Connection getConnection() {

        try {

            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection
            con = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}