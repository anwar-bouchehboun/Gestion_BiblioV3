package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;


import java.time.LocalDate;

public abstract class Document {
    private Integer id;
    private String titre;
    private String auteur;
    private LocalDate datePublication;
    private int nombreDePages;
    private TypeDocument type;
    private  boolean Status;

    public Document(String titre, String auteur, LocalDate datePublication, int nombreDePages,TypeDocument type) {
        this.titre = titre;

        this.auteur = auteur;
        this.datePublication = datePublication;
        this.nombreDePages = nombreDePages;
        this.Status=false;
        this.type=type;
    }
    public Document(){

    }

    public Integer getId() {
        return id;
    }

    // Setter pour id
    public void setId(Integer id) {
        this.id = id;
    }

    public TypeDocument getType() {
        return type;
    }

    public void setType(TypeDocument type) {
        this.type = type;
    }




    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public LocalDate getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(LocalDate datePublication) {
        this.datePublication = datePublication;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setNombreDePages(int nombreDePages) {
        this.nombreDePages = nombreDePages;
    }

    public int getNombreDePages() {
        return nombreDePages;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public abstract void afficherDetails();

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", datePublication='" + datePublication + '\'' +
                ", nombreDePages=" + nombreDePages +
                '}';
    }
}
