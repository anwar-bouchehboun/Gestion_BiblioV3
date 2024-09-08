package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;


import java.time.LocalDate;

public class Magazine extends  Document {

    private Integer Numero;



    public Magazine(String titre, String auteur,LocalDate datePublication, int nombreDePages, int Numero, TypeDocument type) {
        super( titre, auteur, datePublication, nombreDePages,type);
        this.Numero=Numero;
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
