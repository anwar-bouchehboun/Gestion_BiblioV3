package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Dao.*;
import org.gestionBibliothique.Metier.Entite.*;
import org.gestionBibliothique.Utilitaire.InputValidator;
import org.gestionBibliothique.Utilitaire.LoggerMessage;



public class ConsoleUi {

    public static EtudiantnDao etudienDao=new EtudiantnDao();
    public static ProfDao profDao=new ProfDao();
    public static LivreDao livreDao = new LivreDao();
    public static MagazinDao magazinDao = new MagazinDao();
    public static TheseUniversitaireDao theseUniversitaireDao= new TheseUniversitaireDao();
    public static JornalScientifiqueDao jornalScientifiqueDao=new JornalScientifiqueDao();
    public static   JournalTheseUI journalTheseUI=new JournalTheseUI();
    public static MagazinlivreUi magazinlivreUi = new MagazinlivreUi();
    public static UserUI userUI=new UserUI();
    public static EmpruntDao empruntDao =new EmpruntDao();
    public  ConsoleUi(){

    }



    public static void menuPrancipal(){
        do {

            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre désignation  : " + CostumColor.RESET);
            System.out.println("\uD83C\uDFB2|PAppuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (JournalScientifique,ThèseUniversitaire)"      + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Magazine,Livre)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF89|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Prfesseur,Etudiant)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF88 |Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Liste Emprunter/Retouner un document"  + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
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
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre désignation : " + CostumColor.RESET);
            System.out.println("\uD83C\uDFB2|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (Lvire)"      + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (Magazine)"             + CostumColor.RESET);
            System.out.println("\uD83C\uDF89|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (JouranalScinetifique,)"      + CostumColor.RESET);
            System.out.println("\uD83C\uDF88 |Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt  (These_Universitaire)"  + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
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
                    menuJournalEmprunt();
                        break;
                case 4:menuTheseEmprunt();
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

    //livre
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
            System.out.println("✨|Appuyez  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt  (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retour  (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Réserver  (Livre)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Annuler la réservation (Livre)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____Prêt de livres SORTIE__________"+ CostumColor.RESET);
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
                      System.out.println(CostumColor.RED_BOLD_BRIGHT + "Choix invalide");
                      break;

              }
        }while (true);
    }
//magazine

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
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option Magazine  : " + CostumColor.RESET);
            System.out.println("✨|Appuyez  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retour (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Réserver (Magazine)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Annuler la réservation (Magazine)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____Prêt de Magazine SORTIE "+ CostumColor.RESET);
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

    //journal
    public static  void empruntJournal(){
        Document journalScientifique=new JournalScientifique();
        Utilisateur user= new Professeur();
        int idoc =InputValidator.getIntInput("Entre Nombre journalScientifique : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(jornalScientifiqueDao.checkIdJournal_scientifique(idoc) && profDao.checkIdProf(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                journalScientifique.setId(idoc);
                user.setId(iduser);
                empruntDao.emprunter(user, journalScientifique);
            } else {
                LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve OU Emprunt " + CostumColor.RESET);

            }
        }
    }
    public static  void retournerJournal(){
        Document journalScientifique=new JournalScientifique();
        int idoc =InputValidator.getIntInput("Entre Nombre journalScientifique Retourner : ");
        if ( empruntDao.checkDoc(idoc)){
            journalScientifique.setId(idoc);
            empruntDao.retourner(journalScientifique);
        }else {
            LoggerMessage.warn(" journalScientifique ne pas Emprunt");
        }
    }
    public static  void annulerReserveJournal(){
        Document journalScientifique=new JournalScientifique();
        int idoc =InputValidator.getIntInput("Entre Nombre journalScientifique Retourner : ");
        if ( empruntDao.checkReserve(idoc)){
            journalScientifique.setId(idoc);
            empruntDao.annulerReservation(journalScientifique);
        }else {
            LoggerMessage.warn(" journalScientifique ne pas Emprunt");
        }
    }
    public static  void reserveJournal(){
        Document journalScientifique=new JournalScientifique();
        Utilisateur user= new Professeur();
        int idoc =InputValidator.getIntInput("Entre Nombre journalScientifique : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(jornalScientifiqueDao.checkIdJournal_scientifique(idoc) && profDao.checkIdProf(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                journalScientifique.setId(idoc);
                user.setId(iduser);
                empruntDao.reserver(user, journalScientifique);
            } else {
                LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve " + CostumColor.RESET);

            }
        }
    }
    public static  void menuJournalEmprunt(){
        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option journalScientifique  : " + CostumColor.RESET);
            System.out.println("✨|Appuyez  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (journalScientifique)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (journalScientifique)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retour (journalScientifique)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Réserver (journalScientifique)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Annuler la réservation (journalScientifique)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____Prêt de JournalScientifique SORTIE__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            int choix =InputValidator.getIntInput("Entre choix: ");
            switch (choix){
                case 1:
                    empruntJournal();
                    break;
                case 2 :
                    retournerJournal();
                    break;
                case 3 :
                    reserveJournal();
                    break;
                case 4:
                    annulerReserveJournal();
                    break;
                case 5:
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Emprunt journalScientifique _______------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Choix invalide");
                    break;

            }
        }while (true);
    }

    //These
    public static  void empruntThese(){
        Document thèseUniversitaire=new ThèseUniversitaire();
        Utilisateur user= new Professeur();
        int idoc =InputValidator.getIntInput("Entre Nombre thèseUniversitaire : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(theseUniversitaireDao.checkIdTheseUnv(idoc) && profDao.checkIdProf(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                thèseUniversitaire.setId(idoc);
                user.setId(iduser);
                empruntDao.emprunter(user, thèseUniversitaire);
            } else {
                LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve OU Emprunt " + CostumColor.RESET);

            }
        }
    }
    public static  void retournerThese(){
        Document thèseUniversitaire=new ThèseUniversitaire();
        int idoc =InputValidator.getIntInput("Entre Nombre thèseUniversitaire Retourner : ");
        if ( empruntDao.checkDoc(idoc)){
            thèseUniversitaire.setId(idoc);
            empruntDao.retourner(thèseUniversitaire);
        }else {
            LoggerMessage.warn(" thèseUniversitaire ne pas Emprunt");
        }
    }
    public static  void annulerReserveThese(){
        Document thèseUniversitaire=new ThèseUniversitaire();
        int idoc =InputValidator.getIntInput("Entre Nombre thèseUniversitaire Retourner : ");
        if ( empruntDao.checkReserve(idoc)){
            thèseUniversitaire.setId(idoc);
            empruntDao.annulerReservation(thèseUniversitaire);
        }else {
            LoggerMessage.warn(" thèseUniversitaire ne pas Emprunt");
        }
    }
    public static  void reserveThese(){
        Document thèseUniversitaire=new ThèseUniversitaire();
        Utilisateur user= new Etudiant();
        int idoc =InputValidator.getIntInput("Entre Nombre thèseUniversitaire : ");
        int  iduser=InputValidator.getIntInput("Entre Nombre  User :");
        if(theseUniversitaireDao.checkIdTheseUnv(idoc) && profDao.checkIdProf(iduser)) {

            if (!empruntDao.checkReserve(idoc)) {
                thèseUniversitaire.setId(idoc);
                user.setId(iduser);
                empruntDao.reserver(user, thèseUniversitaire);
            } else {
                LoggerMessage.error(CostumColor.PURPLE_BOLD_BRIGHT + "Aucun Reserve Doc deja reserve " + CostumColor.RESET);

            }
        }
    }
    public static  void menuTheseEmprunt(){
        do {
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option thèseUniversitaire  : " + CostumColor.RESET);
            System.out.println("✨|Appuyez  ----" +CostumColor.PURPLE_BOLD_BRIGHT +"|•  (thèseUniversitaire)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Prêt (thèseUniversitaire)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Retour (thèseUniversitaire)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Réserver (thèseUniversitaire)"             + CostumColor.RESET);
            System.out.println("✨|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Annuler la réservation (thèseUniversitaire)"             + CostumColor.RESET);
            System.out.println("\uD83E\uDD47|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Emprunt thèseUniversitaire __________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);
            int choix =InputValidator.getIntInput("Entre choix: ");
            switch (choix){
                case 1:
                    empruntThese();
                    break;
                case 2 :
                    retournerThese();
                    break;
                case 3 :
                    reserveThese();
                    break;
                case 4:
                    annulerReserveThese();
                    break;
                case 5:
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Emprunt thèseUniversitaire_______------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;

            }
        }while (true);
    }
}
