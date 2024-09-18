package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Dao.JornalScientifiqueDao;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bibliotheque {
    public final JornalScientifiqueDao jornalScientifiqueDao = new JornalScientifiqueDao();

    public Bibliotheque(){

    }

//JournalScientifique
    public void diplayDataJournalScientifique(){
        HashMap<Integer, JournalScientifique> dataJornal= jornalScientifiqueDao.findAll();
         //  dataJornal.values().forEach(JournalScientifique::afficherDetails);
        HashMap<TypeDocument, List<JournalScientifique>> data =new HashMap<>();

           dataJornal.values().forEach(j->{
               data.computeIfAbsent(j.getType(),k-> new ArrayList<>()).add(j);
           });
           data.forEach((TypeDocument,d)->{
               LoggerMessage.info("TypeDocument of : " + TypeDocument);

               d.forEach(System.out::println);
           });

        System.out.println("-------------------");
       // dataJornal.values().stream().forEach(JournalScientifique::afficherDetails);
        System.out.println("-------------------");
        dataJornal.values().stream()
                .forEach(JournalScientifique::afficherDetails);
    }

}
