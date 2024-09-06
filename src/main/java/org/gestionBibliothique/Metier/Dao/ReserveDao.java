package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Utilisateur;
import org.gestionBibliothique.Metier.Entite.Document;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReserveDao {

    private final Connection connection;

    public ReserveDao() {
        this.connection = DbConnection.getConnection();
    }

    // Method to reserve a document
  /*  public void reserveDocument(Utilisateur utilisateur, Document document) throws SQLException {
        String query = "INSERT INTO reservation (utilisateur_id, document_id, date_reservation, status) VALUES (?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateur.getId());
            statement.setInt(2, document.getId());
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            statement.setBoolean(4, true);

            statement.executeUpdate();
            System.out.println("Reservation created successfully!");
        } catch (SQLException e) {
            System.err.println("Error creating reservation: " + e.getMessage());
            throw e;
        }
    }

    // Method to cancel a reservation
    public void cancelReservation(int reservationId) throws SQLException {
        String query = "UPDATE reservation SET status = false WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, reservationId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reservation canceled successfully!");
            } else {
                System.out.println("Reservation not found!");
            }
        } catch (SQLException e) {
            System.err.println("Error canceling reservation: " + e.getMessage());
            throw e;
        }
    }*/
}
