package org.gestionBibliothique.Metier;

import java.time.LocalDate;

public class Livre extends  Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn,TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.isbn = isbn;
    }



    @Override
    public String toString() {
        return "Livre{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", datePublication='" + getDatePublication() + '\'' +
                ", nombreDePages=" + getNombreDePages() +
                ", Isbn=" + isbn +
                '}';
    }
}
