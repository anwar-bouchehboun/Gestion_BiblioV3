package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.LoggerMessage;


import java.time.LocalDate;

public class Magazine extends  Document {

    private Integer Numero;



    public Magazine(String titre, String auteur,LocalDate datePublication, int nombreDePages, int Numero, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.Numero=Numero;
    }
    public  void afficherDetails(){
        System.out.printf("%-10d | %-20s | %-30s | %-15s | %-10d  | %-15s  %n",
                getId(), getTitre(), getAuteur(), getDatePublication(), getNombreDePages(),Numero);

       LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");

    }




    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", titre='" + getTitre() + '\'' +
                ", auteur='" + getAuteur() + '\'' +
                ", datePublication='" + getDatePublication() + '\'' +
                ", nombreDePages=" + getNombreDePages() +
                ", Numero=" + Numero +

                '}';
    }





}
