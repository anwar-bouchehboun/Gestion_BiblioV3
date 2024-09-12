package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Metier.Dao.EmpruntDao;
import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Entite.Etudiant;
import org.gestionBibliothique.Metier.Entite.Livre;
import org.gestionBibliothique.Metier.Entite.Utilisateur;
import org.gestionBibliothique.Utilitaire.InputValidator;

import java.lang.reflect.Member;

public class ConsoleUi {

    public static   JournalTheseUI journalTheseUI=new JournalTheseUI();
    public static MagazinlivreUi magazinlivreUi = new MagazinlivreUi();
    public static UserUI userUI=new UserUI();
    public static EmpruntDao empruntDao =new EmpruntDao();
    public  ConsoleUi(){

    }



    public static void menuPrancipal(){
        do {

            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("\uD83C\uDFB2|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (JournalScientifique,ThèseUniversitaire)"      + CostumColor.RESET);
            System.out.println("✨|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Magazine,Livre)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF89|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (JouranalScinetifique,These_Universitaire)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF88 |Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Liste Emprunter/Retouner un document"  + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
               int choix= InputValidator.getIntInput("Entre Choix : ");
               switch(choix){
                   case 1:journalTheseUI.stratJournal();

                       break;
                   case 2 :
                       magazinlivreUi.stratMenu();
                       break;
                   case 3 :
                       userUI.Strat();
                       break;
                   case 4 :
                       menuEmprunt();

                       break;
                   case 5 :
                       System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Prancipal_______------" + CostumColor.RESET);
                       return;
                   default:
                       System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                       break;

               }

        }while(true);
    }



    public static void menuEmprunt(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("\uD83C\uDFB2|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt (Lvire)"      + CostumColor.RESET);
            System.out.println("✨|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt (Magazine)"             + CostumColor.RESET);
            System.out.println("\uD83C\uDF89|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt (JouranalScinetifique,)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF88 |Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt  (These_Universitaire)"  + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            int choix= InputValidator.getIntInput("Entre Choix : ");
            switch (choix){
                case 1:
                    empruntLivre();
                    break;
                case 2:break;
                case 3:break;
                case 4:break;
                case 5 :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Emprunt_______------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;

            }
        }while(true);
    }
public static void empruntLivre(){
    Document livre=new Livre();
    Utilisateur user= new Etudiant();
    int idoc =InputValidator.getIntInput("Entre Nombre Livre : ");
    int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
    livre.setId(idoc);
    user.setId(iduser);
   if( empruntDao.checkReserve(idoc))
   {                System.out.println("Document Deja reservé!");

      }else {
       empruntDao.emprunter(user,livre);
   }

}
}
