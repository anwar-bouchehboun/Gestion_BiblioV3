package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Metier.Enum.TypeUser;

import java.time.LocalDate;

public class Professeur  extends Utilisateur{
    private String IdMassarProf;

    public Professeur(String nom, TypeUser typeUser,LocalDate Date_Insc,String IdMassarProf){
        super(nom,typeUser, Date_Insc);
        this.IdMassarProf=IdMassarProf;

    }
 public Professeur(){

 }


    public String getIdMassarProf() {
        return IdMassarProf;
    }

    public void setIdMassarProf(String IdMassarProf) {
        this.IdMassarProf = IdMassarProf;
    }
}
