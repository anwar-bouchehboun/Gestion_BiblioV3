package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;

public class Livre extends  Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.isbn = isbn;
    }

    public Livre() {

    }

    public  void afficherDetails(){
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                getId(),
                getTitre(),
                getAuteur(),
                getDatePublication(),
                getNombreDePages(),
                isbn));

    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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
