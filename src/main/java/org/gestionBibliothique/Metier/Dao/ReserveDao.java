package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Utilisateur;
import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Interface.Reserver;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ReserveDao implements Reserver<Document> {



    public ReserveDao() {

    }

    @Override
    public void reserver(Utilisateur utilisateur, Document document) {
        int idDoc=documentId(document.getId());
        boolean status=checkDoc(document.getId());
        if (status){
            System.out.println("Document Reserve Déja!");
        }else {
            String query = "INSERT INTO reservations (utilisateur_id, document_id, date_reservation, status) VALUES (?, ?, ?, ?)";

            try (    Connection connection = DbConnection.getConnection();
                     PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, utilisateur.getId());
                statement.setInt(2, idDoc);
                statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
                statement.setBoolean(4, true);

                statement.executeUpdate();
                System.out.println("Reservation created successfully!");
            } catch (SQLException e) {
                System.err.println("Error creating reservation: " + e.getMessage());

            }
        }
    }

    @Override
    public void annulerReservation(int id) {
        String query = "UPDATE reservations SET status = false WHERE id = ?";

        try (    Connection connection = DbConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reservation canceled successfully!");
            } else {
                System.out.println("Reservation not found!");
            }
        } catch (SQLException e) {
            System.err.println("Error canceling reservation: ");
        }
    }

    public Integer documentId(int id){

        String sql = "SELECT id FROM document where  id = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if (resultSet.next()) {

                return resultSet.getInt("id");

            } else {
                System.out.println("No document found with ID: " + id);
                return null;

            }


        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve document ID: " + e.getMessage());
            return null;
        }
    }

    public boolean checkDoc(int id ){
        String sql = "SELECT status FROM reservations where  id_document = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if (resultSet.next()) {

                return resultSet.getBoolean("status");

            } else {
                System.out.println("No reservations found with ID: " + id);
                return false;

            }


        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve reservation ID: " + e.getMessage());
            return false;
        }
    }
    // Method to reserve a document
   public void reserveDocument(Utilisateur utilisateur, Document document) throws SQLException {

       int idDoc=documentId(document.getId());
       boolean status=checkDoc(document.getId());
       if (status){
           System.out.println("Document Reserve Déja!");
       }else {
        String query = "INSERT INTO reservations (utilisateur_id, document_id, date_reservation, status) VALUES (?, ?, ?, ?)";

        try (    Connection connection = DbConnection.getConnection();
              PreparedStatement statement = connection.prepareStatement(query)) {
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
    }

    // Method to cancel a reservation
    public void cancelReservation(int reservationId) throws SQLException {
        String query = "UPDATE reservations SET status = false WHERE id = ?";

        try (    Connection connection = DbConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
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
    }
}
