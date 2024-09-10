package org.gestionBibliothique;

import org.gestionBibliothique.Metier.Dao.*;
import org.gestionBibliothique.Metier.Entite.*;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Presentation.JournalTheseUI;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
       JournalTheseUI j=   new JournalTheseUI();
        j.stratJournal();
    /*  ThèseUniversitaire d= new ThèseUniversitaire();
d.setAuteur("aaaa");
d.setTitre("fffff");
        System.out.print("Enter publication date (yyyy-MM-dd): ");
        LocalDate datePublication = LocalDate.parse(scanner.nextLine());
d.setDatePublication(datePublication);
d.setNombreDePages(333);
d.setType(TypeDocument.THESE_UNIVERSITAIRE);
d.setUniversite("Youcode");
TheseUniversitaireDao dao = new TheseUniversitaireDao();

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