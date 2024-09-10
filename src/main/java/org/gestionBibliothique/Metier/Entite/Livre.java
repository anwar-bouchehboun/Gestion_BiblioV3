package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class Livre extends  Document {
    private String isbn;

    public Livre(String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.isbn = isbn;
    }
    public  void afficherDetails(){
        System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d  | %-15s  %n",
                getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),isbn);


        LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");

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
