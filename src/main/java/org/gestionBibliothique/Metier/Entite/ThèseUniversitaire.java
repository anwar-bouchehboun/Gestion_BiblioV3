package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;

import java.time.LocalDate;

public class ThèseUniversitaire extends Document  {
    private String domaine;
    private  String universite;
    public ThèseUniversitaire(String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaine, String universite, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.domaine = domaine;
        this.universite=universite;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }
    public String getUniversite(){
        return  universite;
    }


}
