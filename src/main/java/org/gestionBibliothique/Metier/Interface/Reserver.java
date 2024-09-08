package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Entite.Utilisateur;

public interface Reserver  <Doc extends Document>  {

        void reserver(Utilisateur utilisateur, Doc document);
        void annulerReservation(int id);

}
