package org.gestionBibliothique.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Etudiant;
import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Metier.Interface.UserInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EtudiantnDao implements UserInterface<Etudiant> {
    public static HashMap<Integer, Etudiant> Etu= new HashMap<>();

    @Override
    public void create(Etudiant utilisateur) {
        try {
            String sql = "INSERT INTO etudiant(nom, typeuser, date_inscription, id_massar) VALUES (?, ?::TypeUser, ?, ?)";
            Connection connection = DbConnection.getInstance().getConnection();
            PreparedStatement stmt =connection.prepareStatement(sql);
            stmt.setString(1,utilisateur.getNom());
            stmt.setString(2,utilisateur.getTypeUser().name());
            LocalDate dateInsc = LocalDate.now();
            stmt.setDate(3, java.sql.Date.valueOf(dateInsc));
            stmt.setString(4,utilisateur.getIdMassar());
            int row= stmt.executeUpdate();
            if (row>0){
                LoggerMessage.info("Etudiant created successfully.");

            }else {
                LoggerMessage.warn("Failed to create Etudiant.");

            }
        } catch (Exception e) {
            LoggerMessage.error("Failed to Error ."+e);
        }
    }



    @Override
    public void update(Etudiant utilisateur) {
        try {
            String query = "UPDATE etudiant SET nom=?,id_massar=? WHERE id = ?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);

            stmt.setString(1, utilisateur.getNom());
            stmt.setString(2, utilisateur.getIdMassar());
            stmt.setInt(3, utilisateur.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("Etudiant avec l'ID \"" + utilisateur.getId() + "\" mis à jour avec succès.");
            } else {
                LoggerMessage.warn("Aucun Etudiant trouvé avec l'ID \"" + utilisateur.getId() + "\".");
            }
        } catch (Exception e) {
            LoggerMessage.error(" Error" +e);
        }
    }


    @Override
    public void delete(Etudiant utilisateur)  {
        try {
            Etu.remove(utilisateur.getId());

            String sql="DELETE FROM etudiant WHERE id =?";
            PreparedStatement stmt=DbConnection.getInstance().getConnection().prepareStatement(sql);
            stmt.setInt(1,utilisateur.getId());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                LoggerMessage.info("Etudiant avec l'ID \"" + utilisateur.getId() + "\" Delete avec succès.");
            } else {
                LoggerMessage.warn("Aucun Etudiant trouvé avec l'ID \"" + utilisateur.getId() + "\".");
            }
        }catch (Exception e){
            LoggerMessage.error(" Error" +e);

        }
    }

    @Override
    public HashMap<Integer, Etudiant> findAll() {
        try {
            String sql="SELECT * FROM etudiant order by id DESC";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Etudiant p= new Etudiant();
                p.setId(resultSet.getInt("id"));
                p.setNom(resultSet.getString("nom"));
                p.setTypeUser(TypeUser.valueOf(resultSet.getString("typeuser")));
                p.setDate_Insc(resultSet.getDate("date_inscription").toLocalDate());
                p.setIdMassar(resultSet.getString("id_massar"));
                Etu.put(p.getId(), p);
            }
            return Etu;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void displayGet(Etudiant GetDATA) {
        LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-25s | %-20s%n",
                GetDATA.getId(),
                GetDATA.getNom(),
                GetDATA.getTypeUser(),
                GetDATA.getDate_Insc(),
                GetDATA.getIdMassar()));
    }
    @Override
    public void DisplayData() {
        HashMap<Integer, Etudiant> E = findAll();
        if (E.isEmpty()) {
            System.out.println("No Etudiant available.");
            return;
        }
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-25s | %-20s%n",
                "ID", "Nom", "TypeUser", "Date Inscription", "IdMassar"));
        for (Map.Entry<Integer, Etudiant> entry : E.entrySet()) {
            Etudiant GetDATA = entry.getValue();
            displayGet(GetDATA);
        }
    }
    //Check ID
    public Optional<Etudiant> checkId(Integer id){
        return Optional.ofNullable(Etu.get(id));

    }
    @Override
    public Optional<Etudiant> finId(Etudiant utilisateur) {
        findAll();
        Optional<Etudiant> p= checkId(utilisateur.getId());
        if (p.isPresent()) {
            Etudiant Etudiant = p.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-25s | %-20s%n",
                    "ID", "Nom", "TypeUser", "Date Inscription", "IdMassar"
            ));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-25s | %-20s%n",
                    Etudiant.getId(),
                    Etudiant.getNom(),
                    Etudiant.getTypeUser(),
                    Etudiant.getDate_Insc(),
                    Etudiant.getIdMassar()));
        } else {
            System.out.println("No Etudiant found with ID: " + utilisateur.getId());
        }
        return p;
    }

    public Integer profId(Etudiant utilisateur) {

        String sql = "SELECT id FROM etudiant where  id = ?";
        try (

             PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, utilisateur.getId());
         ResultSet resultSet = preparedStatement.executeQuery() ;
                if (resultSet.next()) {

                    return resultSet.getInt("id");

                } else {
                    System.out.println("No Etudiant found with ID: " + utilisateur.getId());
                    return null;

                }


        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve etudiant ID: " + e.getMessage());
            return null;
        }
    }
    public boolean checkIdEtu(int id) {
        String sql = "SELECT id FROM etudiant WHERE id = ?";
        try (

                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve etudiant ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve etudiant ID: " + e.getMessage());
            return false;
        }
    }
}
