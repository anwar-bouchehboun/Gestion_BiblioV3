package org.gestionBibliothique;

import org.gestionBibliothique.Metier.Dao.EtudienDao;
import org.gestionBibliothique.Metier.Dao.JornalScientifiqueDao;
import org.gestionBibliothique.Metier.Dao.ProfDao;
import org.gestionBibliothique.Metier.Entite.Etudiant;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Entite.Professeur;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Metier.Enum.TypeUser;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        EtudienDao profDao=new EtudienDao();

        Etudiant p=new Etudiant();
        p.setId(12);

        int x=profDao.profId(p);
System.out.printf(""+x);







    /*     JornalScientifiqueDao dao= new JornalScientifiqueDao();
      dao.DisplayData();

        System.out.print("Enter ID : ");
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



     u.setId(id);
     u.setAuteur(auteur);
     u.setTitre(titre);
     u.setDomaineRecherche(domaineRecherche);
     u.setDatePublication(datePublication);
     u.setNombreDePages(nombreDePages);
     dao.update(u);

        scanner.close();*/

        // dao.finId(1);
      /*  JournalScientifique j= new JournalScientifique();
        j.setId((4));
        dao.delete(j);*/
       /* JournalScientifique u= new JournalScientifique();
        u.setId(3);
        dao.finId(u);*/

    }

}