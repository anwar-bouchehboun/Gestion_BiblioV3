package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Utilisateur;

public interface Reservable {
 void réserver(Utilisateur utilisateur) ;
 void annulerRéservation();
}
