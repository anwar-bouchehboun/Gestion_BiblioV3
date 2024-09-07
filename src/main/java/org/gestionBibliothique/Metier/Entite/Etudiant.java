package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;

import java.time.LocalDate;

public class Etudiant extends Utilisateur {
    private String IdMassar;

    public Etudiant(String nom, TypeUser typeUser, LocalDate Date_Insc, String IdMassar){
        super(nom,typeUser,Date_Insc);
        this.IdMassar=IdMassar;

    }


    public String getIdMassar() {
        return IdMassar;
    }

    public void setIdMassar(String IdMassar) {
        this.IdMassar = IdMassar;
    }
}
