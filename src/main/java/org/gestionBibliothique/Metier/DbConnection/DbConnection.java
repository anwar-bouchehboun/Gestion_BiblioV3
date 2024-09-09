package org.gestionBibliothique.Metier.DbConnection;

import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    private static DbConnection instance;
    private Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Bibliothique";
    private static final String USER = "postgres";
    private static final String PASS = "2024";

    // Private constructor to prevent instantiation from outside the class
    private DbConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            LoggerMessage.error("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            synchronized (DbConnection.class) {
                if (instance == null) {  // Double-check locking
                    instance = new DbConnection();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
            }
        } catch (SQLException e) {
            LoggerMessage.error("Failed to re-establish the database connection: " + e.getMessage());
        }
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                LoggerMessage.info("Database connection closed");
            } catch (SQLException e) {
                LoggerMessage.error("Failed to close the database connection: " + e.getMessage());
            }
        }
    }
}
