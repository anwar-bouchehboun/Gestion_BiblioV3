package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Utilisateur;
import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Interface.Empruntable;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class EmpruntDao implements Empruntable<Document> {


    public EmpruntDao() {
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
    // Method to return a document

    public void retourner(int empruntId)  {
        String query = "UPDATE emprunt SET date_retour = ?, status = false WHERE id = ?";

        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            statement.setInt(2, empruntId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Document returned successfully!");
            } else {
                System.out.println("Document  not found!");
            }
        } catch (SQLException e) {
            System.err.println("Error returning document: " + e.getMessage());

        }
    }

    @Override
    public void emprunter(Utilisateur utilisateur, Document document)  {
        int idDoc=documentId(document.getId());
         boolean status=checkDoc(document.getId());
       if (status){
           System.out.println("Document Emprunt Déja!");
       }else {

        String query = "INSERT INTO emprunt (id_utilisateur,id_document, date_emprunt, status) VALUES (?, ?, ?, ?)";

        try (
                Connection connection = DbConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, utilisateur.getId());
            statement.setInt(2, idDoc);
            statement.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            statement.setBoolean(4, true);

            statement.executeUpdate();
            System.out.println("Document Emprunt successfully!");
        } catch (SQLException e) {
            System.err.println("Error borrowing document: " + e.getMessage());

        }
       }
    }




    public boolean checkDoc(int id ){
        String sql = "SELECT status FROM emprunt where  id_document = ?";
        try (Connection connection = DbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery() ;
            if (resultSet.next()) {

                return resultSet.getBoolean("status");

            } else {
                System.out.println("No emprunt found with ID: " + id);
                return false;

            }


        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve emprunt ID: " + e.getMessage());
            return false;
        }
    }
}
