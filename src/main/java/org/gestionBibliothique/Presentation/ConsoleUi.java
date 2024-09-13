package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Metier.Dao.*;
import org.gestionBibliothique.Metier.Entite.*;
import org.gestionBibliothique.Utilitaire.InputValidator;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.lang.reflect.Member;
import java.util.Optional;
import java.util.function.Function;

public class ConsoleUi {

    public static EtudienDao etudienDao=new EtudienDao();
    public static ProfDao profDao=new ProfDao();
    public static LivreDao livreDao = new LivreDao();
    public static MagazinDao magazinDao = new MagazinDao();
    public static TheseUniversitaireDao theseUniversitaireDao= new TheseUniversitaireDao();
    public static  JornalScientifiqueDao jornalScientifiqueDao=new JornalScientifiqueDao();
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
                    menuLivreEmprunt();
                    break;
                case 2:
                    menuMagazineEmprunt();
                        break;
                case 3:
                        break;
                case 4:
                        break;
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
    if(livreDao.checkIdLivre(idoc)  && etudienDao.checkIdEtu(iduser)){
        livre.setId(idoc);
        user.setId(iduser);
        if( empruntDao.checkReserve(idoc))
        {
            System.out.println(CostumColor.PURPLE_BOLD_BRIGHT +"Document Deja reservé!"+ CostumColor.RESET);

        }else {
            empruntDao.emprunter(user,livre);
        }
    }



}

public static  void retournerLivre(){
    Document livre=new Livre();
    int idoc =InputValidator.getIntInput("Entre Nombre Livre Retourner : ");
   if ( empruntDao.checkDoc(idoc)){
       livre.setId(idoc);
       empruntDao.retourner(livre);
   }else {
       LoggerMessage.warn(" livre ne pas Emprunt");
   }
}
public  static void reserveLivre(){
    Document livre=new Livre();
    Utilisateur user= new Etudiant();
    int idoc =InputValidator.getIntInput("Entre Nombre Livre : ");
    int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
    if(livreDao.checkIdLivre(idoc) && etudienDao.checkIdEtu(iduser)) {

        if (!empruntDao.checkReserve(idoc)) {
            livre.setId(idoc);
            user.setId(iduser);
            empruntDao.reserver(user, livre);
        } else {
            System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve " + CostumColor.RESET);

        }
    }
}
public static  void annulerReserveLivre(){
    Document livre=new Livre();
    int idoc =InputValidator.getIntInput("Entre Nombre Livre Retourner : ");
    if ( empruntDao.checkReserve(idoc)){
        livre.setId(idoc);
        empruntDao.annulerReservation(livre);
    }else {
        LoggerMessage.warn(" livre ne pas Emprunt");
    }
}
    public static  void menuLivreEmprunt(){
        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option Livre  : " + CostumColor.RESET);
            System.out.println("✨|Press  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Press  1-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Press  2-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Press  3-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Reserve (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Press  4-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Anuuler Reserve (Livre)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Emprunt Livre__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            int choix =InputValidator.getIntInput("Entre choix: ");
              switch (choix){
                  case 1:
                      //Emprunt
                      empruntLivre();
                      break;
                  case 2 :
                      //Retourner
                      retournerLivre();
                      break;
                  case 3 :
                      //Reserve
                      reserveLivre();

                      break;
                  case 4 :
                      //Annuler
                      annulerReserveLivre();
                      break;

                  case 5:
                  System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Emprunt Livre_______------" + CostumColor.RESET);
                  return;
                  default:
                      System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                      break;

              }
        }while (true);
    }


    public static  void empruntMagazine(){
        Document magazine=new Magazine();
        Utilisateur user= new Etudiant();
        int idoc =InputValidator.getIntInput("Entre Nombre Magazine : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(magazinDao.checkIdMagazine(idoc) && etudienDao.checkIdEtu(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                magazine.setId(idoc);
                user.setId(iduser);
                empruntDao.emprunter(user, magazine);
            } else {
                LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve OU Emprunt " + CostumColor.RESET);

            }
        }
    }
    public static  void retournerMagazine(){
        Document magazine=new Magazine();
        int idoc =InputValidator.getIntInput("Entre Nombre magazine Retourner : ");
        if ( empruntDao.checkDoc(idoc)){
            magazine.setId(idoc);
            empruntDao.retourner(magazine);
        }else {
            LoggerMessage.warn(" Magazine ne pas Emprunt");
        }
    }
    public static  void annulerReserveMagazine(){
        Document magazine=new Magazine();
        int idoc =InputValidator.getIntInput("Entre Nombre magazine Retourner : ");
        if ( empruntDao.checkReserve(idoc)){
            magazine.setId(idoc);
            empruntDao.annulerReservation(magazine);
        }else {
            LoggerMessage.warn(" magazine ne pas Emprunt");
        }
    }
    public static  void reserveMagazine(){
        Document magazine=new Magazine();
        Utilisateur user= new Etudiant();
        int idoc =InputValidator.getIntInput("Entre Nombre Magazine : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(magazinDao.checkIdMagazine(idoc) && etudienDao.checkIdEtu(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                magazine.setId(idoc);
                user.setId(iduser);
                empruntDao.reserver(user, magazine);
            } else {
              LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve " + CostumColor.RESET);

            }
        }
    }
    public static  void menuMagazineEmprunt(){
        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option Livre  : " + CostumColor.RESET);
            System.out.println("✨|Press  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Press  1-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Emprunt (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Press  2-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retourner (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Press  3-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Reserve (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Press  4-to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Annuler Reserve (Magazine)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Emprunt Magazine__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            int choix =InputValidator.getIntInput("Entre choix: ");
            switch (choix){
                case 1:
                    empruntMagazine();
                    break;
                case 2 :
                     retournerMagazine();
                    break;
                case 3 :
                    reserveMagazine();
                    break;
                case 4:
                    annulerReserveMagazine();
                    break;
                case 5:
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Emprunt Magazine_______------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;

            }
        }while (true);
    }

}
