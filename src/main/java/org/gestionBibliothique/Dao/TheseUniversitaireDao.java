package org.gestionBibliothique.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Entite.ThèseUniversitaire;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Interface.DocumentInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.*;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TheseUniversitaireDao implements DocumentInterface<ThèseUniversitaire> {

    public static HashMap<Integer, ThèseUniversitaire> These= new HashMap<>();

    @Override
    public void create(ThèseUniversitaire document) {
        String query = "INSERT INTO these_universitaire (titre, auteur, date_publication, nombre_de_pages, type, \"université\") VALUES (?, ?, ?, ?, ?, ?)";

        try (

                PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());

            LocalDate datePublication = document.getDatePublication();
            if (datePublication != null) {
                stmt.setDate(3, java.sql.Date.valueOf(datePublication));
            }

            stmt.setInt(4, document.getNombreDePages());
            stmt.setObject(5, document.getType(), java.sql.Types.OTHER);
            stmt.setString(6, document.getUniversite());


            // Execute the update and check the result
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("these_universitaire created successfully.");

            } else {
                LoggerMessage.warn("Failed to create these_universitaire.");

            }

        } catch (SQLException e) {
            LoggerMessage.error("Error creating these_universitaire"+ e);
        }
    }

    @Override
    public Optional<ThèseUniversitaire> finId(ThèseUniversitaire document) {
        findAll();
        Optional<ThèseUniversitaire> J= checkId(document.getId());
        if (J.isPresent()) {
            ThèseUniversitaire journal = J.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                    "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Universite"));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                    journal.getId(),
                    journal.getTitre(),
                    journal.getAuteur(),
                    journal.getDatePublication().toString(),
                    journal.getNombreDePages(),
                    journal.getType().name(),
                    journal.getUniversite()));
        } else {
            System.out.println("No ThèseUniversitaire found with ID: " + document.getId());
        }
        return J;
    }

    @Override
    public void update(ThèseUniversitaire document) {
        try {
            String query = "UPDATE these_universitaire SET titre=?, auteur=?, date_publication=?, nombre_de_pages=?, \"université\"=? WHERE id = ?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());
            stmt.setDate(3, java.sql.Date.valueOf(document.getDatePublication()));
            stmt.setInt(4, document.getNombreDePages());
            stmt.setString(5, document.getUniversite());
            stmt.setInt(6, document.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.warn("Document avec l'ID \"" + document.getId() + "\" mis à jour avec succès.");
            } else {
                LoggerMessage.warn("Aucun document trouvé avec l'ID \"" + document.getId() + "\".");
            }
        } catch (Exception e) {
            LoggerMessage.error("Error updating these_universitaire");
        }
    }

    @Override
    public void delete(ThèseUniversitaire document) {
        try {
            These.remove(document.getId());
            String query = "DELETE FROM these_universitaire WHERE id = ?";
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
    public HashMap<Integer, ThèseUniversitaire> findAll() {

        try {
            String sql = "SELECT * FROM these_universitaire";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                ThèseUniversitaire p = new ThèseUniversitaire();
                p.setId(resultSet.getInt("id"));
                p.setTitre(resultSet.getString("titre"));
                p.setAuteur(resultSet.getString("auteur"));
                p.setDatePublication(resultSet.getDate("date_publication").toLocalDate());
                p.setNombreDePages(resultSet.getInt("nombre_de_pages"));
                p.setType(TypeDocument.valueOf(resultSet.getString("type")));
                p.setUniversite(resultSet.getString("université"));

                These.put(p.getId(), p);
            }

            return These;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }    }


    //Display Data
    public void DisplayData() {
        HashMap<Integer, ThèseUniversitaire> Journal = findAll();
        if (Journal.isEmpty()) {
            System.out.println("No Universitaire available.");
            return;
        }
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Universitaire"));
        for (Map.Entry<Integer, ThèseUniversitaire> entry : Journal.entrySet()) {
            ThèseUniversitaire GetDATA = entry.getValue();
            displayGet(GetDATA);
        }
    }
    //Display GetData
    private void displayGet(ThèseUniversitaire GetDATA) {
        LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                GetDATA.getId(),
                GetDATA.getTitre(),
                GetDATA.getAuteur(),
                GetDATA.getDatePublication().toString(),
                GetDATA.getNombreDePages(),
                GetDATA.getType().name(),
                GetDATA.getUniversite()));
    }
    @Override
    public Integer readId(ThèseUniversitaire document) {
        return 0;
    }
    public Optional<ThèseUniversitaire> checkId(Integer id){
        return Optional.ofNullable(These.get(id));
    }
    public boolean checkIdTheseUnv(int id) {
        String sql = "SELECT id FROM these_universitaire WHERE id = ?";
        try (
                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve these_universitaire ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve these_universitaire ID: " + e.getMessage());
            return false;
        }
    }

}
