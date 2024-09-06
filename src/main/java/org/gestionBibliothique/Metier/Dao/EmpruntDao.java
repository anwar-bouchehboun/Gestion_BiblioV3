package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Utilisateur;
import org.gestionBibliothique.Metier.Entite.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmpruntDao {
    private final Connection connection;

    public EmpruntDao() {
        this.connection = DbConnection.getConnection();
    }
/*
    // Method to borrow a document
    public void emprunterDocument(Utilisateur utilisateur, Document document) throws SQLException {
        String query = "INSERT INTO emprunt (utilisateur_id, document_id, date_emprunt, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateur.getId()); // Assuming Utilisateur has a getId() method
            statement.setInt(2, document.getId()); // Assuming Document has a getId() method
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now())); // Current date for borrowing
            statement.setBoolean(4, true); // Borrowing is active

            statement.executeUpdate();
            System.out.println("Document borrowed successfully!");
        } catch (SQLException e) {
            System.err.println("Error borrowing document: " + e.getMessage());
            throw e;
        }
    }

    // Method to return a document
    public void retournerDocument(int empruntId) throws SQLException {
        String query = "UPDATE emprunt SET date_retour = ?, status = false WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, java.sql.Date.valueOf(LocalDate.now())); // Current date for returning
            statement.setInt(2, empruntId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Document returned successfully!");
            } else {
                System.out.println("Borrow record not found!");
            }
        } catch (SQLException e) {
            System.err.println("Error returning document: " + e.getMessage());
            throw e;
        }
    }*/
}
