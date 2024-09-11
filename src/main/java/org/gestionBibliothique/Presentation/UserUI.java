package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Metier.Dao.ProfDao;
import org.gestionBibliothique.Metier.Entite.Etudiant;
import org.gestionBibliothique.Metier.Entite.JournalScientifique;
import org.gestionBibliothique.Metier.Entite.Professeur;
import org.gestionBibliothique.Metier.Enum.TypeUser;
import org.gestionBibliothique.Utilitaire.InputValidator;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.util.HashMap;

public class UserUI {

    public final ProfDao profDao=new ProfDao();
    public final Professeur professeur=new Professeur();
    public final Etudiant etudiant =new Etudiant();
    public UserUI(){

    }

    public void Strat(){
        do {
            MenuUser();
            int choix=InputValidator.getIntInput("Entre Choix :");

            switch(choix){
                case 1:menuMiseAjourUserProf();
                        break;
                case 2:
                    break;
                case 3:
                    menuRechercheUser();
                    break;
                case 4 :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu User_______------" + CostumColor.RESET);
                    return;

                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        }while(true);


    }

    public void MenuUser(){
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
        System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Professeur)"      + CostumColor.RESET);
        System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Etudiant)"      + CostumColor.RESET);
        System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document(Professeur ou Etudiant) "+ CostumColor.RESET);
        System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

    }


    public void menuRechercheUser(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un user (Professeur )"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un user   (Etudiant)"+ CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Menu Rechecheche __________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

            int input= InputValidator.getIntInput("Entre Choix : ");
            switch(input){
                case 1:
                    rechercheIdProf();
                    break;
                case 2:
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

    public void menuMiseAjourUserProf(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choose  Option from Below According to your Designation  : " + CostumColor.RESET);
            System.out.println("|Press 1 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un User (Professeur )"      + CostumColor.RESET);
            System.out.println("|Press 2 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Modifier un User "  + CostumColor.RESET);
            System.out.println("|Press 3 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Supprimer un User   (Professeur )"+ CostumColor.RESET);
            System.out.println("|Press 4 to" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche un User   (Professeur)"+ CostumColor.RESET);
            System.out.println("|Press 5 to" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Professeur__________"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

            int input=InputValidator.getIntInput("Entre Choix : ");
            switch(input){
                case 1:
                    createProf();
                    break;
                case 2:
                    updatProf();
                    break;
                case 3:
                    deleteProf();
                    break;
                case 4 :
                    displayDataProf();
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

    public void createProf(){
        String nomProf=InputValidator.getStringInput("Entre Professeur");
        String idmassarProf=InputValidator.getStringInput("Entre IdmssarProf");
        professeur.setNom(nomProf);
        professeur.setIdMassarProf(idmassarProf);
        professeur.setTypeUser(TypeUser.Professeur);
        profDao.create(professeur);

    }
    public void updatProf(){
        int id = InputValidator.getIntInput(" Entre Nombre Modifier");
        if(profDao.checkIdProf(id)){
        String nomProf=InputValidator.getStringInput("Entre Professeur");
        String idmassarProf=InputValidator.getStringInput("Entre IdmssarProf");
        professeur.setId(id);
        professeur.setNom(nomProf);
        professeur.setIdMassarProf(idmassarProf);
        profDao.update(professeur);

        }
    }
    public  void deleteProf(){
        int id = InputValidator.getIntInput(" Entre Nombre Supprimer");
        if(profDao.checkIdProf(id)){
            professeur.setId(id);
            profDao.delete(professeur);
        }
    }
    public void displayDataProf(){
        HashMap<Integer, Professeur> dataJornal= profDao.findAll();
        LoggerMessage.info(String.format("%-10s | %-30s | %-15s | %-15s %n",
                "ID", "Titre", "Date Publication", "IDMassar"));
        dataJornal.values().forEach(Professeur::afficherDetails);
    }
    public void rechercheIdProf(){
        int id=  InputValidator.getIntInput("Entre Recherche ID :");
        professeur.setId(id);
        profDao.finId(professeur);
    }
}
