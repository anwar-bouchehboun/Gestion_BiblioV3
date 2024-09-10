package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Metier.Dao.JornalScientifiqueDao;
import org.gestionBibliothique.Metier.Dao.TheseUniversitaireDao;
import org.gestionBibliothique.Metier.Entite.Bibliotheque;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Entite.ThèseUniversitaire;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.DateUtlis;
import org.gestionBibliothique.Utilitaire.InputValidator;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class JournalTheseUI {
    public final Bibliotheque bibliotheque =new Bibliotheque();
    public final JournalScientifique journalScientifique = new JournalScientifique();
    public  final  JornalScientifiqueDao jornalScientifiqueDao = new JornalScientifiqueDao();
    public final ThèseUniversitaire theseUniversitaire = new ThèseUniversitaire();
    public final TheseUniversitaireDao theseUniversitaireDao =new TheseUniversitaireDao();
    private final Scanner choix = new Scanner(System.in);

    public JournalTheseUI(){

    }

    public void stratJournal() {
do{
    MenuStartJournal();


    int ch = InputValidator.getIntInput("Entre Choix : ");
        switch (ch) {
            case 1:
                menuMiseAjourJournal();
                break;
            case 2:
                menuMiseAjourThese();
                break;
            case 3:
//EMprunt
                break;
            case 4:
                menuRecherche();
                break;

            case 5:
                System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Journal_______------" + CostumColor.RESET);
                return;


            default:
                System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }while(true);

    }

    public void MenuStartJournal(){
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
        System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (JournalScientifique)"      + CostumColor.RESET);
        System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (ThèseUniversitaire)"      + CostumColor.RESET);
        System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Liste Emprunter/Retouner un document"  + CostumColor.RESET);
        System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document(JournalScientifique ou ThèseUniversitaire) "+ CostumColor.RESET);
        System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

    }
    //Journal
    public void createJournal(){
      String titre=  InputValidator.getStringInput("Entre Titre :");
        String auteur=  InputValidator.getStringInput("Entre Auteur :");
        int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
        String Domaine=  InputValidator.getStringInput("Entre Domaine Recherche :");
       LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
        journalScientifique.setType(TypeDocument.JOURNAL_SCIENTIFIQUE);
        journalScientifique.setNombreDePages(numberPage);
        journalScientifique.setDomaineRecherche(Domaine);
        journalScientifique.setDatePublication(date);
        journalScientifique.setTitre(titre);
        journalScientifique.setAuteur(auteur);
         jornalScientifiqueDao.create(journalScientifique);

    }
    public void updateJournal(){
        int id= InputValidator.getIntInput("Entre Nombre RECHERCHE Modifier :");

      boolean idCheck= jornalScientifiqueDao.checkIdJournal_scientifique(id);
      if(idCheck){
          String titre=  InputValidator.getStringInput("Entre Titre :");
          String auteur=  InputValidator.getStringInput("Entre Auteur :");
          int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
          String Domaine=  InputValidator.getStringInput("Entre Domaine Recherche :");
          LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
          journalScientifique.setId(id);
          journalScientifique.setNombreDePages(numberPage);
          journalScientifique.setDomaineRecherche(Domaine);
          journalScientifique.setDatePublication(date);
          journalScientifique.setTitre(titre);
          journalScientifique.setAuteur(auteur);
          jornalScientifiqueDao.update(journalScientifique);
      }



    }
    public void deleteJournal(){
        int id= InputValidator.getIntInput("Entre Nombre RECHERCHE Supprimer :");
        boolean idCheck= jornalScientifiqueDao.checkIdJournal_scientifique(id);
        if(idCheck){
            journalScientifique.setId(id);
            jornalScientifiqueDao.delete(journalScientifique);


        }
    }
    public void displayData(){

        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages", "Domaine Recherche"));
        LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");
        bibliotheque.diplayDataJournalScientifique();


    }

    public void menuMiseAjourJournal(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (JournalScientifique )"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Modifier un document "  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Supprimer un document   (JournalScientifique )"+ CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche un document   (JournalScientifique)"+ CostumColor.RESET);
            System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT JournalT__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

               int input=InputValidator.getIntInput("Entre Choix : ");
               switch(input){
                   case 1: createJournal();
                       break;
                   case 2:  updateJournal();
                       break;
                   case 3:  deleteJournal();
                       break;
                   case 4 :
                           displayData();
                       break;
                   case 5 :
                       System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit MenuJ_____------" + CostumColor.RESET);
                       return;
                   default:
                       System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                       break;
               }
        }while (true);
    }
    public void rrechercheTitreJournal(){
        int id=  InputValidator.getIntInput("Entre Recherche ID :");
        journalScientifique.setId(id);
         jornalScientifiqueDao.finId(journalScientifique);

    }

    //These
    public void createThese(){
        String titre=  InputValidator.getStringInput("Entre Titre :");
        String auteur=  InputValidator.getStringInput("Entre Auteur :");
        int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
        LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
        String unv=InputValidator.getStringInput("Entre Univistaire : ");
        theseUniversitaire.setType(TypeDocument.THESE_UNIVERSITAIRE);
        theseUniversitaire.setNombreDePages(numberPage);
        theseUniversitaire.setUniversite(unv);
        theseUniversitaire.setDatePublication(date);
        theseUniversitaire.setTitre(titre);
        theseUniversitaire.setAuteur(auteur);
        theseUniversitaireDao.create(theseUniversitaire);
    }
    public void  updateThese(){
        int id= InputValidator.getIntInput("Entre Nombre RECHERCHE Modifier :");

        boolean idCheck= theseUniversitaireDao.checkIdTheseUnv(id);
        if(idCheck){
            String titre=  InputValidator.getStringInput("Entre Titre :");
            String auteur=  InputValidator.getStringInput("Entre Auteur :");
            int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
            String unv=InputValidator.getStringInput("Entre Univistaire : ");
            LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
            theseUniversitaire.setId(id);
            theseUniversitaire.setNombreDePages(numberPage);
            theseUniversitaire.setUniversite(unv);
            theseUniversitaire.setDatePublication(date);
            theseUniversitaire.setTitre(titre);
            theseUniversitaire.setAuteur(auteur);
            theseUniversitaireDao.update(theseUniversitaire);
        }
    }
    public void deleteThese(){
        int id= InputValidator.getIntInput("Entre Nombre RECHERCHE Supprimer :");
        boolean idCheck= theseUniversitaireDao.checkIdTheseUnv(id);
        if(idCheck){
            theseUniversitaire.setId(id);
            theseUniversitaireDao.delete(theseUniversitaire);


        }
    }
    public void displayDataThese(){
        HashMap<Integer,ThèseUniversitaire> data=theseUniversitaireDao.findAll();
        LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages",  "Universitaire"));
        LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");

        data.values().forEach(ThèseUniversitaire::afficherDetails);
    }
    public void rrechercheTitreThese(){
        int id=  InputValidator.getIntInput("Entre Recherche ID :");

    }
    public void menuMiseAjourThese(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (ThèseUniversitaire )"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Modifier un document "  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Supprimer un document   (ThèseUniversitaire )"+ CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche un document   (ThèseUniversitaire)"+ CostumColor.RESET);
            System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT ThèseUniversitaire__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

            int input=InputValidator.getIntInput("Entre Choix : ");
            switch(input){
                case 1:
                    createThese();
                    break;
                case 2:updateThese();
                    break;
                case 3:
                    deleteThese();
                    break;
                case 4 :
                    displayDataThese();
                    break;
                case 5 :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit MenuThese_____------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        }while (true);
    }
    public void menuRecherche(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un document (ThèseUniversitaire )"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un document   (JournalScientifique)"+ CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Menu Rechecheche __________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

            int input=InputValidator.getIntInput("Entre Choix : ");
            switch(input){
                case 1:
                    rrechercheTitreThese();
                    break;
                case 2:
                    rrechercheTitreJournal();
                    break;
                case 3:
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit MenuJ_____------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        }while (true);
    }
}
