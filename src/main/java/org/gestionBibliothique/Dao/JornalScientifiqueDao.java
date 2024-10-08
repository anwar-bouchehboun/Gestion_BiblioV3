package org.gestionBibliothique.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Interface.DocumentInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.*;
import java.time.LocalDate;

import java.util.HashMap;

import java.util.Map;
import java.util.Optional;

public class JornalScientifiqueDao implements DocumentInterface<JournalScientifique> {



    public static HashMap<Integer, JournalScientifique> Journal= new HashMap<>();

    @Override
    public void create(JournalScientifique document) {
        String query = "INSERT INTO journal_scientifique (titre, auteur, date_publication, nombre_de_pages, type, domainerecherche) VALUES (?, ?, ?, ?, ?, ?)";

        try (

             PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query)) {

            // Set parameters for the PreparedStatement
            stmt.setString(1, document.getTitre());
            stmt.setString(2, document.getAuteur());

            // Handle LocalDate conversion
            LocalDate datePublication = document.getDatePublication();
            if (datePublication != null) {
                stmt.setDate(3, java.sql.Date.valueOf(datePublication));
            } else {
                stmt.setNull(3, java.sql.Types.DATE); // Handle null dates if applicable
            }

            stmt.setInt(4, document.getNombreDePages());
            stmt.setObject(5, document.getType(), java.sql.Types.OTHER);
            stmt.setString(6, document.getDomaineRecherche());

            // Execute the update and check the result
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("JournalScientifique created successfully.");

            } else {
                LoggerMessage.warn("Failed to create JournalScientifique.");

            }

        } catch (SQLException e) {
            LoggerMessage.error("Error creating JournalScientifique"+ e);
        }
    }



    @Override
    public void update(JournalScientifique document) {
    try {
        String query = "UPDATE journal_scientifique SET titre=?, auteur=?, date_publication=?, nombre_de_pages=?, domainerecherche=? WHERE id = ?";
        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, document.getTitre());
        stmt.setString(2, document.getAuteur());
        stmt.setDate(3, java.sql.Date.valueOf(document.getDatePublication()));
        stmt.setInt(4, document.getNombreDePages());
        stmt.setString(5, document.getDomaineRecherche());
        stmt.setInt(6, document.getId());
        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
           LoggerMessage.warn("Document avec l'ID \"" + document.getId() + "\" mis à jour avec succès.");
        } else {
            LoggerMessage.warn("Aucun document trouvé avec l'ID \"" + document.getId() + "\".");
        }
    } catch (Exception e) {
        LoggerMessage.error("Error updating JournalScientifique");
    }
    }
//Delete JournalScientifique
    @Override
    public void delete(JournalScientifique document) {
        try {
            Journal.remove(document.getId());
            String query = "DELETE FROM journal_scientifique WHERE id = ?";
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


//Qwery for Give data
    @Override
    public HashMap<Integer, JournalScientifique> findAll()  {

        try {
            String sql = "SELECT * FROM journal_scientifique";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                JournalScientifique p = new JournalScientifique();
                p.setId(resultSet.getInt("id"));
                p.setTitre(resultSet.getString("titre"));
                p.setAuteur(resultSet.getString("auteur"));
                p.setDatePublication(resultSet.getDate("date_publication").toLocalDate());
                p.setNombreDePages(resultSet.getInt("nombre_de_pages"));
                p.setType(TypeDocument.valueOf(resultSet.getString("type")));
                p.setDomaineRecherche(resultSet.getString("domainerecherche"));

                Journal.put(p.getId(), p);
            }

            return Journal;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Display Data
    public void DisplayData() {
        HashMap<Integer, JournalScientifique> Journal = findAll();
        if (Journal.isEmpty()) {
            System.out.println("No JournalScientifique available.");
            return;
        }
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Domaine Recherche"));
        for (Map.Entry<Integer, JournalScientifique> entry : Journal.entrySet()) {
            JournalScientifique GetDATA = entry.getValue();
            displayGet(GetDATA);
        }
    }
//Display GetData
    private void displayGet(JournalScientifique GetDATA) {
        LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                GetDATA.getId(),
                GetDATA.getTitre(),
                GetDATA.getAuteur(),
                GetDATA.getDatePublication().toString(),
                GetDATA.getNombreDePages(),
                GetDATA.getType().name(),
                GetDATA.getDomaineRecherche()));
    }
//READ DATA ID
    @Override
    public Optional<JournalScientifique> finId(JournalScientifique document) {
        findAll();
        Optional<JournalScientifique> J= checkId(document.getId());
        if (J.isPresent()) {
            JournalScientifique journal = J.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-14s | %-25s | %-20s%n",
                    "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Type", "Domaine Recherche"));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-20s | %-14d | %-25s | %-20s%n",
                    journal.getId(),
                    journal.getTitre(),
                    journal.getAuteur(),
                    journal.getDatePublication().toString(),
                    journal.getNombreDePages(),
                    journal.getType().name(),
                    journal.getDomaineRecherche()));
        } else {
            System.out.println("No JournalScientifique found with ID: " + document.getId());
        }
        return J;

    }
    //Check ID
    public Optional<JournalScientifique> checkId(Integer id){
        return Optional.ofNullable(Journal.get(id));

    }
    public Integer readId(JournalScientifique document) {
        String sql = "SELECT id FROM journal_scientifique WHERE id = ?";
        try (
             PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

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
            LoggerMessage.error("Failed to retrieve journal_scientifique ID: " + e.getMessage());
            return null;
        }
    }
    public boolean checkIdJournal_scientifique(int id) {
        String sql = "SELECT id FROM journal_scientifique WHERE id = ?";
        try (
                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve journal_scientifique ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve journal_scientifique ID: " + e.getMessage());
            return false;
        }
    }

}
