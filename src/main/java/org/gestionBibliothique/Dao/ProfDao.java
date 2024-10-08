package org.gestionBibliothique.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.Professeur;
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


public class ProfDao implements UserInterface<Professeur> {
 public static HashMap<Integer, Professeur> Professeur= new HashMap<>();

    @Override
    public void create(Professeur utilisateur) {
         try {
             String sql = "INSERT INTO professeur(nom, typeuser, date_inscription, idmassarprof) VALUES (?, ?::TypeUser, ?, ?)";
             Connection connection = DbConnection.getInstance().getConnection();
             PreparedStatement stmt =connection.prepareStatement(sql);
             stmt.setString(1,utilisateur.getNom());
             stmt.setString(2,utilisateur.getTypeUser().name());
             LocalDate dateInsc = LocalDate.now();
             stmt.setDate(3, java.sql.Date.valueOf(dateInsc));
             stmt.setString(4,utilisateur.getIdMassarProf());
             int row= stmt.executeUpdate();
             if (row>0){
                 LoggerMessage.info("Professeur created successfully.");

             }else {
                 LoggerMessage.warn("Failed to create Professeur.");

             }
         } catch (Exception e) {
             LoggerMessage.error("Failed to Error ."+e);
         }
    }



    @Override
    public void update(Professeur utilisateur) {
        try {
            String query = "UPDATE professeur SET nom=?, idmassarprof=? WHERE id = ?";
            PreparedStatement stmt = DbConnection.getInstance().getConnection().prepareStatement(query);

            stmt.setString(1, utilisateur.getNom());
       //     stmt.setString(2, utilisateur.getTypeUser().name());
            stmt.setString(2, utilisateur.getIdMassarProf());
            stmt.setInt(3, utilisateur.getId());

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
               LoggerMessage.info("Professeur avec l'ID \"" + utilisateur.getId() + "\" mis à jour avec succès.");
            } else {
                LoggerMessage.warn("Aucun Professeur trouvé avec l'ID \"" + utilisateur.getId() + "\".");
            }
        } catch (Exception e) {
            LoggerMessage.error(" Error" +e);
        }
    }


    @Override
    public void delete(Professeur utilisateur)  {
       try {
           Professeur.remove(utilisateur.getId());
           String sql="DELETE FROM professeur WHERE id =?";
           PreparedStatement stmt=DbConnection.getInstance().getConnection().prepareStatement(sql);
           stmt.setInt(1,utilisateur.getId());
           int rowsAffected = stmt.executeUpdate();
           if (rowsAffected > 0) {
               LoggerMessage.info("Professeur avec l'ID \"" + utilisateur.getId() + "\" Delete avec succès.");
           } else {
               LoggerMessage.warn("Aucun Professeur trouvé avec l'ID \"" + utilisateur.getId() + "\".");
           }
       }catch (Exception e){
           LoggerMessage.error(" Error" +e);

       }
    }

    @Override
    public HashMap<Integer, Professeur> findAll() {
        try {
            String sql="SELECT * FROM professeur order by id DESC";
            Statement statement = DbConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Professeur p= new Professeur();
                p.setId(resultSet.getInt("id"));
                p.setNom(resultSet.getString("nom"));
                p.setTypeUser(TypeUser.valueOf(resultSet.getString("typeuser")));
                p.setDate_Insc(resultSet.getDate("date_inscription").toLocalDate());
                p.setIdMassarProf(resultSet.getString("idmassarprof"));
                Professeur.put(p.getId(), p);
            }
         return Professeur;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private void displayGet(Professeur GetDATA) {
        LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-25s | %-20s%n",
                GetDATA.getId(),
                GetDATA.getNom(),
                GetDATA.getTypeUser(),
                GetDATA.getDate_Insc(),
                GetDATA.getIdMassarProf()));
    }
    @Override
    public void DisplayData() {
        HashMap<Integer, Professeur> p = findAll();
        if (p.isEmpty()) {
            System.out.println("No Professeur available.");
            return;
        }
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-25s | %-20s%n",
                "ID", "Nom", "TypeUser", "Date Inscription", "IdMassarProf"));
        for (Map.Entry<Integer, Professeur> entry : p.entrySet()) {
            Professeur GetDATA = entry.getValue();
            displayGet(GetDATA);
        }
    }

    //Check ID
    public  Optional<Professeur> checkId(Integer id){
        return Optional.ofNullable(Professeur.get(id));

    }
    @Override
    public Optional<Professeur> finId(Professeur utilisateur) {
        findAll();
        Optional<Professeur> p= checkId(utilisateur.getId());
        if (p.isPresent()) {
            Professeur professeur = p.get();
            LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-25s | %-20s%n",
                    "ID", "Nom", "TypeUser", "Date Inscription", "IdMassarProf"
            ));
            LoggerMessage.info(String.format("%-10d | %-20s | %-20s | %-25s | %-20s%n",
                    professeur.getId(),
                    professeur.getNom(),
                    professeur.getTypeUser(),
                    professeur.getDate_Insc(),
                    professeur.getIdMassarProf()));
        } else {
            System.out.println("No Professeur found with ID: " + utilisateur.getId());
        }
        return p;
    }


    public Integer profId(Professeur utilisateur) {
        String sql = "SELECT id FROM professeur WHERE id = ?";
        try (
             PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, utilisateur.getId());
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt("id");
                } else {
                    return null;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve professor ID: " + e.getMessage());
            return null;
        }
    }
    public boolean checkIdProf(int id) {
        String sql = "SELECT id FROM professeur WHERE id = ?";
        try (
                PreparedStatement preparedStatement = DbConnection.getInstance().getConnection().prepareStatement(sql)) {

            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                } else {
                    LoggerMessage.warn("Failed to retrieve professeur ID:  "+id);
                    return false;
                }
            }

        } catch (Exception e) {
            LoggerMessage.error("Failed to retrieve professeur ID: " + e.getMessage());
            return false;
        }
    }


}
