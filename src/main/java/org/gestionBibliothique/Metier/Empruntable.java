package org.gestionBibliothique.Metier;

public interface Empruntable {
    void emprunter(Utilisateur utilisateur);
    void retourner();
}
