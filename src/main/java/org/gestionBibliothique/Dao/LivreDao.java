package org.gestionBibliothique.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Livre;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Interface.DocumentInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class LivreDao implements DocumentInterface<Livre> {
    public LivreDao(){

    }
    public static HashMap<Integer, Livre> livre= new HashMap<>();


    @Override
    public void create(Livre document) {
        String query = "INSERT INTO livre (titre, auteur, date_publication, nombre_de_pages, type,isbn) VALUES (?, ?, ?, ?, ?, ?)";
        try (

                PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            LocalDate datePublication = document.getDatePublication();
            stmt.setDate(3, java.sql.Date.valueOf(datePublication));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setObject(5, document.getType(), java.sql.Types.OTHER);
            stmt.setString(6, document.getIsbn());

            // Execute the update and check the result
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("livre created successfully.");

            } else {
                LoggerMessage.warn("Failed to create livre.");

            }

        }
        catch (SQLException e) {
            LoggerMessage.error("Error creating livre"+ e);
        }
    }



    @Override
    public void update(Livre document) {
        try {
            String query = "UPDATE livre SET titre=?, auteur=?, date_publication=?, nombre_de_pages=?,isbn=? WHERE id = ?";
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(document.getDatePublication()));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setString(5, document.getIsbn());
            stmt.setInt(6, document.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.warn("Document avec l'ID \"" + document.getId() + "\" mis à jour avec succès.");
            } else {
                LoggerMessage.warn("Aucun document trouvé avec l'ID \"" + document.getId() + "\".");
            }
        } catch (Exception e) {
            LoggerMessage.error("Error updating Livre");
        }
    }

    @Override
    public void delete(Livre document) {
        try {
           livre.remove(document.getId());
            String query = "DELETE FROM livre WHERE id = ?";
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(query);
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
    public HashMap<Integer, Livre> findAll() {

        try {
            String sql = "SELECT * FROM livre";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Livre p = new Livre();
                p.setId(resultSet.getInt("id"));
                p.setTitre(resultSet.getString("titre"));
                p.setAuteur(resultSet.getString("auteur"));
                p.setDatePublication(resultSet.getDate("date_publication").toLocalDate());
                p.setNombreDePages(resultSet.getInt("nombre_de_pages"));
                p.setType(TypeDocument.valueOf(resultSet.getString("type")));
                p.setIsbn(resultSet.getString("isbn"));

               livre .put(p.getId(), p);
            }

            return livre;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void DisplayData() {

    }

    @Override
    public Integer readId(Livre document) {
        String sql = "SELECT id FROM livre WHERE id = ?";
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
            LoggerMessage.error("Failed to retrieve livre ID: " + e.getMessage());
            return null;
        }
    }

    public Optional<Livre> finId(Livre document) {
        findAll();
        Optional<Livre> J= checkId(document.getId());
        if (J.isPresent()) {
            Livre l = J.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                    "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Isbn"));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                    l.getId(),
                    l.getTitre(),
                    l.getAuteur(),
                    l.getDatePublication().toString(),
                    l.getNombreDePages(),
                    l.getType().name(),
                    l.getIsbn()));
        } else {
            System.out.println("No LIVRE found with ID: " + document.getId());
        }
        return J;

    }
    //Check ID
    public Optional<Livre> checkId(Integer id){
        return Optional.ofNullable(livre.get(id));

    }
    public boolean checkIdLivre(int id) {
        String sql = "SELECT id FROM livre WHERE id = ?";
        try (
                Connection connection = DbConnection.getInstance().getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve livre ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve LIVRE ID: " + e.getMessage());
            return false;
        }
    }
}
