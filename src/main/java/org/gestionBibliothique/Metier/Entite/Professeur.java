package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class Professeur  extends Utilisateur{
    private String IdMassarProf;

    public Professeur(String nom, TypeUser typeUser,LocalDate Date_Insc,String IdMassarProf){
        super(nom,typeUser, Date_Insc);
        this.IdMassarProf=IdMassarProf;

    }
 public Professeur(){

 }


    public String getIdMassarProf() {
        return IdMassarProf;
    }

    public void setIdMassarProf(String IdMassarProf) {
        this.IdMassarProf = IdMassarProf;
    }
    public  void afficherDetails(){
        LoggerMessage.info(String.format("%-10d |  %-30s | %-15s | %-15s  %n",
                getId(), getNom(), getDate_Insc(), getIdMassarProf()));



    }
}
