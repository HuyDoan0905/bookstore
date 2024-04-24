package com.demo.bookstore.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "12345";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            // Register the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Create the connection
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("Da ket noi");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new SQLException("Failed to connect to database.");
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        try (Connection connection = ConnectDB.getConnection()) {
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}