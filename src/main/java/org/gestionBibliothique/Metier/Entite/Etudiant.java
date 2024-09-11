package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class Etudiant extends Utilisateur {
    private String IdMassar;

    public Etudiant(String nom, TypeUser typeUser, LocalDate Date_Insc, String IdMassar){
        super(nom,typeUser,Date_Insc);
        this.IdMassar=IdMassar;

    }

    public Etudiant(){

    }

    public String getIdMassar() {
        return IdMassar;
    }

    public void setIdMassar(String IdMassar) {
        this.IdMassar = IdMassar;
    }
    public  void afficherDetails(){
        LoggerMessage.info(String.format("%-10d |  %-30s | %-15s | %-15s  %n",
                getId(), getNom(), getDate_Insc(), getIdMassar()));

        LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");

    }
}
