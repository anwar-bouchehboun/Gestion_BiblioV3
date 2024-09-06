package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Metier.Interface.Empruntable;
import org.gestionBibliothique.Metier.Interface.Reservable;

public abstract   class Utilisateur {
    private Integer id;
    private String nom;
    private TypeUser typeUser;

    public Utilisateur(String nom,TypeUser typeUser){
        this.nom=nom;
        this.typeUser=typeUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


}
