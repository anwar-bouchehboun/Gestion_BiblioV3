package org.gestionBibliothique;

import org.gestionBibliothique.Metier.Dao.EmpruntDao;
import org.gestionBibliothique.Metier.Dao.EtudienDao;
import org.gestionBibliothique.Metier.Dao.JornalScientifiqueDao;
import org.gestionBibliothique.Metier.Dao.ProfDao;
import org.gestionBibliothique.Metier.Entite.*;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Presentation.JournalScUI;
import org.gestionBibliothique.Utilitaire.DateUtlis;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        JournalScUI j=   new JournalScUI();
        j.stratJournal();
     /*   JournalScientifique d= new JournalScientifique();
d.setAuteur("aaaa");
d.setTitre("fffff");
        System.out.print("Enter publication date (yyyy-MM-dd): ");
        LocalDate datePublication = LocalDate.parse(scanner.nextLine());
d.setDatePublication(datePublication);
d.setNombreDePages(333);
d.setType(TypeDocument.JOURNAL_SCIENTIFIQUE);
JornalScientifiqueDao dao = new JornalScientifiqueDao();
dao.create(d);*/








     /*   System.out.print("Enter ID : ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter title: ");
        String titre = scanner.nextLine();

        System.out.print("Enter author: ");
        String auteur = scanner.nextLine();

        System.out.print("Enter publication date (yyyy-MM-dd): ");
        LocalDate datePublication = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter number of pages: ");
        int nombreDePages = Integer.parseInt(scanner.nextLine());

   System.out.print("Enter document type (MAGAZINE,LIVRE,JOURNAL_SCIENTIFIQUE,THESE_UNIVERSITAIRE): ");
        TypeDocument type = TypeDocument.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Enter research domain: ");
        String domaineRecherche = scanner.nextLine();

*/





    }

}