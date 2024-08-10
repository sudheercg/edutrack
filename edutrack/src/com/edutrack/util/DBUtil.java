package com.edutrack.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/eduTrackDB";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Static block to load the MySQL JDBC driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error loading MySQL driver: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    // Method to establish and return a connection to the database
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Optional: Method to close a connection
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
