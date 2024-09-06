package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;

import java.time.LocalDate;

public class JournalScientifique extends Document {
    private String domaineRecherche;

    public JournalScientifique(String titre, String auteur, LocalDate datePublication, int nombreDePages, String domaineRecherche, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.domaineRecherche = domaineRecherche;
    }
    public JournalScientifique(){
        super();

    }
    public String getDomaineRecherche() {
        return domaineRecherche;
    }

    public void setDomaineRecherche(String domaineRecherche) {
        this.domaineRecherche = domaineRecherche;
    }



}
