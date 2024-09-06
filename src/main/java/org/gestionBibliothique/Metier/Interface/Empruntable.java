package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Utilisateur;

public interface Empruntable {
    void emprunter(Utilisateur utilisateur);
    void retourner();
}
