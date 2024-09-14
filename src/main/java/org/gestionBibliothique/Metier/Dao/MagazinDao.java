package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Magazine;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Interface.DocumentInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class MagazinDao implements DocumentInterface<Magazine> {

    public MagazinDao(){

    }
    public static HashMap<Integer, Magazine> magazine= new HashMap<>();

    @Override
    public void create(Magazine document) {
        String query = "INSERT INTO magazine (titre, auteur, date_publication, nombre_de_pages, type,numero) VALUES (?, ?, ?, ?, ?, ?)";
        try (

                PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            LocalDate datePublication = document.getDatePublication();
            stmt.setDate(3, java.sql.Date.valueOf(datePublication));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setObject(5, document.getType(), java.sql.Types.OTHER);
            stmt.setInt(6, document.getNumero());

            // Execute the update and check the result
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("Magazine created successfully.");

            } else {
                LoggerMessage.warn("Failed to create livre.");

            }

        }
        catch (SQLException e) {
            LoggerMessage.error("Error creating livre"+ e);
        }
    }


    @Override
    public void update(Magazine document) {
        try {
            String query = "UPDATE magazine SET titre=?, auteur=?, date_publication=?, nombre_de_pages=?,numero=? WHERE id = ?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(document.getDatePublication()));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setInt(5, document.getNumero());
            stmt.setInt(6, document.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.warn("Document avec l'ID \"" + document.getId() + "\" mis à jour avec succès.");
            } else {
                LoggerMessage.warn("Aucun document trouvé avec l'ID \"" + document.getId() + "\".");
            }
        } catch (Exception e) {
            LoggerMessage.error("Error updating Magazine");
        }
    }

    @Override
    public void delete(Magazine document) {
        try {
            magazine.remove(document.getId());
            String query = "DELETE FROM magazine WHERE id = ?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setInt(1,document.getId());
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                LoggerMessage.warn("Document avec l'ID \"" + document.getId() + "\" a été supprimé avec succès.");
            } else {
                LoggerMessage.warn("Aucun document trouvé avec l'ID \"" + document.getId() + "\".");
            }

        } catch (SQLException e) {
            LoggerMessage.error("Erreur lors de la suppression du document : " + e.getMessage());
        }
    }

    @Override
    public HashMap<Integer, Magazine> findAll() {

        try {
            String sql = "SELECT * FROM magazine";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Magazine p = new Magazine();
                p.setId(resultSet.getInt("id"));
                p.setTitre(resultSet.getString("titre"));
                p.setAuteur(resultSet.getString("auteur"));
                p.setDatePublication(resultSet.getDate("date_publication").toLocalDate());
                p.setNombreDePages(resultSet.getInt("nombre_de_pages"));
                p.setType(TypeDocument.valueOf(resultSet.getString("type")));
                p.setNumero(resultSet.getInt("numero"));

                magazine .put(p.getId(), p);
            }

            return magazine;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DisplayData() {

    }

    @Override
    public Integer readId(Magazine document) {
        String sql = "SELECT id FROM magazine WHERE id = ?";
        try (
                Connection connection = DbConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, document.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                } else {
                    LoggerMessage.warn("Failed Id");
                    return null;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve magazine ID: " + e.getMessage());
            return null;
        }
    }


    public Optional<Magazine> finId(Magazine document) {
        findAll();
        Optional<Magazine> J= checkId(document.getId());
        if (J.isPresent()) {
            Magazine l = J.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                    "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Numero"));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                    l.getId(),
                    l.getTitre(),
                    l.getAuteur(),
                    l.getDatePublication().toString(),
                    l.getNombreDePages(),
                    l.getType().name(),
                    l.getNumero()));
        } else {
            System.out.println("No MAGAZINE found with ID: " + document.getId());
        }
        return J;

    }
    //Check ID
    public Optional<Magazine> checkId(Integer id){
        return Optional.ofNullable(magazine.get(id));

    }
    public boolean checkIdMagazine(int id) {
        String sql = "SELECT id FROM magazine WHERE id = ?";
        try (
                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve MAGAZINE ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve MAGAZINE ID: " + e.getMessage());
            return false;
        }
    }
}
