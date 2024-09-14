package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Dao.JornalScientifiqueDao;

import java.util.HashMap;

public class Bibliotheque {
    public final JornalScientifiqueDao jornalScientifiqueDao = new JornalScientifiqueDao();

    public Bibliotheque(){

    }

//JournalScientifique
    public void diplayDataJournalScientifique(){
        HashMap<Integer, JournalScientifique> dataJornal= jornalScientifiqueDao.findAll();
           dataJornal.values().forEach(JournalScientifique::afficherDetails);
    }

}
