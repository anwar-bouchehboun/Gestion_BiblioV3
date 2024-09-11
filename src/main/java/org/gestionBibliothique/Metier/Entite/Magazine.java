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
    public  Magazine(){

    }
    public  void afficherDetails(){
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                getId(),
                getTitre(),
                getAuteur(),
                getDatePublication(),
                getNombreDePages(),
                Numero));
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
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
