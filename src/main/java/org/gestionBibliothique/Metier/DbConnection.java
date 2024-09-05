package org.gestionBibliothique.Metier;

import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    final static String DB_URL = "jdbc:postgresql://localhost:5432/Bibliothique";
    final static String USER = "postgres";
    final static String PASS = "2024";
    private static Connection connection;

    public static Connection getConnection()  {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DB_URL, USER, PASS);
                LoggerMessage.info("Conexion Succes");
            }
        } catch (SQLException e) {
            LoggerMessage.error("Failed to connect to the database");

        }
        return connection;
    }


}
