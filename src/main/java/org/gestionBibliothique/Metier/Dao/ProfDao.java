package org.gestionBibliothique.Metier.Dao;

import org.gestionBibliothique.Metier.DbConnection.DbConnection;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Entite.Professeur;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Metier.Interface.UserInterface;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Optional;

public class ProfDao implements UserInterface<Professeur> {
 public static HashMap<Integer, Professeur> Professeur= new HashMap<>();

    @Override
    public void create(Professeur utilisateur) {
         try {
             String sql = "INSERT INTO professeur(nom, typeuser, date_inscription, idmassarprof) VALUES (?, ?::TypeUser, ?, ?)";
             Connection connection = DbConnection.getConnection();
             PreparedStatement stmt =connection.prepareStatement(sql);
             stmt.setString(1,utilisateur.getNom());
             stmt.setString(2,utilisateur.getTypeUser().name());
             LocalDate dateInsc = utilisateur.getDate_Insc();
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
    public Optional<Professeur> finId(Professeur utilisateur) {
        return Optional.empty();
    }

    @Override
    public void update(Professeur utilisateur) {

    }

    @Override
    public void delete(Professeur utilisateur) {

    }

    @Override
    public HashMap<Integer, Professeur> findAll() {
        try {
            String sql="SELECT * FROM public.professeur order by id DESC";
            Statement statement = DbConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Professeur p= new Professeur();
                p.setId(resultSet.getInt("id"));
                p.setNom(resultSet.getString("nom"));
                p.setTypeUser(TypeUser.valueOf(resultSet.getString("typeuser")));
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void DisplayData() {

    }
    //Check ID
    public Optional<Professeur> checkId(Integer id){
        return Optional.ofNullable(Professeur.get(id));

    }
}
