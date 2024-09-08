package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Entite.Utilisateur;

public interface Empruntable <Doc extends Document>{
    void emprunter(Utilisateur utilisateur,Doc document);
    void retourner(int id);
}
