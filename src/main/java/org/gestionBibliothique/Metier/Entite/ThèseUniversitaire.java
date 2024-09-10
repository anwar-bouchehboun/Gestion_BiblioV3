package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class ThèseUniversitaire extends Document  {
    private  String universite;
    public ThèseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaine, String universite, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.universite=universite;
    }
public ThèseUniversitaire(){

}


    public void setUniversite(String universite) {
        this.universite = universite;
    }
    public String getUniversite(){
        return  universite;
    }
    public  void afficherDetails(){


        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                getId(),
                getTitre(),
                getAuteur(),
                getDatePublication(),
                getNombreDePages(),
                universite));
    }

}
