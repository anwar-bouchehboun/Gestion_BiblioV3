package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;

import java.time.LocalDate;


public abstract   class Utilisateur {
    private Integer id;
    private String nom;
    private TypeUser typeUser;
    private LocalDate Date_Insc;

    public Utilisateur(String nom,TypeUser typeUser,LocalDate Date_Insc){
        this.nom=nom;
        this.typeUser=typeUser;
        this.Date_Insc=Date_Insc;
    }
    public Utilisateur(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate_Insc() {
        return Date_Insc;
    }

    public void setDate_Insc(LocalDate date_Insc) {
        Date_Insc = date_Insc;
    }

    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public abstract void afficherDetails();

}
