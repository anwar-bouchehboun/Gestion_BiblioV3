package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Interface.Empruntable;
import org.gestionBibliothique.Metier.Interface.Reservable;

import java.time.LocalDate;

public class Magazine extends  Document implements Empruntable, Reservable {

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


    @Override
    public void emprunter(Utilisateur utilisateur) {
        if(!isStatus()){
            this.setStatus(true);

        }
    }

    @Override
    public void retourner() {

    }

    @Override
    public void réserver(Utilisateur utilisateur) {

    }

    @Override
    public void annulerRéservation() {

    }
}
