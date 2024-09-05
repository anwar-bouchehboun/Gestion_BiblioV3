package org.gestionBibliothique.Metier;

public interface Réservable {
 void réserver(Utilisateur utilisateur) ;
 void annulerRéservation();
}
