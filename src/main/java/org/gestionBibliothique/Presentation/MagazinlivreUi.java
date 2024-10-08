package org.gestionBibliothique.Presentation;

import org.gestionBibliothique.Dao.LivreDao;
import org.gestionBibliothique.Dao.MagazinDao;
import org.gestionBibliothique.Metier.Entite.Livre;
import org.gestionBibliothique.Metier.Entite.Magazine;
import org.gestionBibliothique.Metier.Enum.TypeDocument;
import org.gestionBibliothique.Utilitaire.DateUtlis;
import org.gestionBibliothique.Utilitaire.InputValidator;
import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;
import java.util.HashMap;

public class MagazinlivreUi {

    public final LivreDao livreDao=new LivreDao();
    public final Livre  livre = new Livre();
    public final Magazine magazine=new Magazine();
    public final MagazinDao magazinDao= new MagazinDao();
      public  MagazinlivreUi(){

      }

      public void stratMenu(){
          do {
              menuStartLivre();
              int ch= InputValidator.getIntInput("Entre choix");
              switch (ch){
                  case 1:
                      menuMiseAjourLivre();
                      break;
                  case 2:
                      menuMiseAjourMagazine();
                      break;
                  case 3:
                      menuRecherche();
                  break;
                  case 4:
                      System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu Livre Magazine_______------" + CostumColor.RESET);
                      return;
                  default:
                      System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                      break;
              }

          }while (true);
      }


    public void menuStartLivre(){
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre Désignation  : " + CostumColor.RESET);
        System.out.println("||Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Livre)"      + CostumColor.RESET);
        System.out.println("||Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• GESTION (Magazine)"      + CostumColor.RESET);
        System.out.println("||Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Rechercher un document(Livre ou Magazine) "+ CostumColor.RESET);
        System.out.println("||Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT__________"+ CostumColor.RESET);
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

    }

    public void menuMiseAjourLivre(){
        do {
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre Désignation  : " + CostumColor.RESET);
            System.out.println("|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (Livre )"      + CostumColor.RESET);
            System.out.println("|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Modifier un document Livre "  + CostumColor.RESET);
            System.out.println("|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Supprimer un document   (Livre )"+ CostumColor.RESET);
            System.out.println("|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche un document   (Livre)"+ CostumColor.RESET);
            System.out.println("|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Livre"+ CostumColor.RESET);
            System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
            System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

            int input=InputValidator.getIntInput("Entre Choix : ");
            switch(input){
                case 1:
                    createLivre();
                    break;
                case 2:updateLivre();
                    break;
                case 3:
                    deleteLivre();
                    break;
                case 4 :
                    diplayData();
                    break;
                case 5 :
                    System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu_____------" + CostumColor.RESET);
                    return;
                default:
                    System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                    break;
            }
        }while (true);
    }
//livre
      public void createLivre(){
          String titre=  InputValidator.getStringInput("Entre Titre :");
          String auteur=  InputValidator.getStringInput("Entre Auteur :");
          int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
          LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
          String isbn=InputValidator.getStringInput("Entre Isbn  : ");
          livre.setIsbn(isbn);
          livre.setTitre(titre);
          livre.setAuteur(auteur);
          livre.setNombreDePages(numberPage);
          livre.setDatePublication(date);
          livre.setType(TypeDocument.LIVRE);
          livreDao.create(livre);

      }
      public void updateLivre(){
          int id =InputValidator.getIntInput("Entre ID Modifer :");

          if(livreDao.checkIdLivre(id)){
              String titre=  InputValidator.getStringInput("Entre Titre :");
              String auteur=  InputValidator.getStringInput("Entre Auteur :");
              int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
              LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
              String isbn=InputValidator.getStringInput("Entre Isbn  : ");

              livre.setId(id);
              livre.setIsbn(isbn);
              livre.setAuteur(auteur);
              livre.setDatePublication(date);
              livre.setNombreDePages(numberPage);
              livre.setTitre(titre);
              livreDao.update(livre);
          }
      }
      public  void deleteLivre(){
          int id =InputValidator.getIntInput("Entre ID Supprimer :");

          if(livreDao.checkIdLivre(id)){
              livre.setId(id);
              livreDao.delete(livre);

          }
      }
      public  void diplayData(){

          HashMap<Integer,Livre> livre=livreDao.findAll();
          LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                  "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages",  "Isbn"));
          LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");
          livre.values().forEach(Livre::afficherDetails);
      }
//Magazine
public void menuMiseAjourMagazine(){
    do {
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre Désignation : " + CostumColor.RESET);
        System.out.println("|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Ajouter un document (Magazine )"      + CostumColor.RESET);
        System.out.println("|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Modifier un document Magazine "  + CostumColor.RESET);
        System.out.println("|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Supprimer un document   (Magazine )"+ CostumColor.RESET);
        System.out.println("|Appuyez sur 4 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Affiche un document   (Magazine)"+ CostumColor.RESET);
        System.out.println("|Appuyez sur 5 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Magazine"+ CostumColor.RESET);
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

        int input=InputValidator.getIntInput("Entre Choix : ");
        switch(input){
            case 1:
            createMagazine();
                break;
            case 2:
                updateMagazine();
                break;
            case 3:
                deleteMagazine();
                break;
            case 4 :
                diplayDataMagaizne();
                break;
            case 5 :
                System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit Menu_____------" + CostumColor.RESET);
                return;
            default:
                System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }while (true);
}
public  void createMagazine(){
    String titre=  InputValidator.getStringInput("Entre Titre :");
    String auteur=  InputValidator.getStringInput("Entre Auteur :");
    int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
    LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
    int numero=InputValidator.getIntInput("Entre Numero  : ");
    magazine.setNumero(numero);
    magazine.setTitre(titre);
    magazine.setAuteur(auteur);
    magazine.setNombreDePages(numberPage);
    magazine.setDatePublication(date);
    magazine.setType(TypeDocument.MAGAZINE);
    magazinDao.create(magazine);
}
public  void updateMagazine(){
          int id =InputValidator.getIntInput("Entre ID Modifier : ");
          if(magazinDao.checkIdMagazine(id)){
              String titre=  InputValidator.getStringInput("Entre Titre :");
              String auteur=  InputValidator.getStringInput("Entre Auteur :");
              int numberPage= InputValidator.getIntInput("Entre Nombre de page :");
              LocalDate date= DateUtlis.getDateInput("Entre Date Publication :");
              int numero=InputValidator.getIntInput("Entre Numero  : ");

              magazine.setId(id);
              magazine.setNumero(numero);
              magazine.setTitre(titre);
              magazine.setAuteur(auteur);
              magazine.setNombreDePages(numberPage);
              magazine.setDatePublication(date);
              magazinDao.update(magazine);
          }
      }
public void deleteMagazine(){
          int id =InputValidator.getIntInput("Entre ID Supprimer :");

          if(magazinDao.checkIdMagazine(id)){
              magazine.setId(id);
              magazinDao.delete(magazine);

          }
      }
public void diplayDataMagaizne(){
          HashMap<Integer,Magazine> magazine=magazinDao.findAll();
          LoggerMessage.info(String.format("%-10s | %-20s | %-20s | %-20s | %-25s | %-20s%n",
                  "ID", "Titre", "Auteur", "Date Publication", "Nombre Pages",  "Numero"));
          LoggerMessage.info("---------------------------------------------------------------------------------------------------------------------------------");
          magazine.values().forEach(Magazine::afficherDetails);
      }

//Recherche Menu
public void menuRecherche(){
    do {
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println(CostumColor.BLUE_BOLD_BRIGHT+"|Choisissez l'option ci-dessous en fonction de votre Désignation\n : " + CostumColor.RESET);
        System.out.println("|Appuyez sur 1 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un document (Livre )"      + CostumColor.RESET);
        System.out.println("|Appuyez sur 2 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"|• Recherche un document   (Magazine)"+ CostumColor.RESET);
        System.out.println("|Appuyez sur 3 pour" +CostumColor.PURPLE_BOLD_BRIGHT +"| _____EXIT Menu Rechecheche __________"+ CostumColor.RESET);
        System.out.println(CostumColor.BROWN_BACKGROUND+CostumColor.WHITE_BOLD_BRIGHT+"----------------------------------------------------------- "+ CostumColor.RESET);
        System.out.println("Choix => : " +CostumColor.PURPLE_BOLD_BRIGHT + " CHOIX "+ CostumColor.RESET);

        int input=InputValidator.getIntInput("Entre Choix : ");
        switch(input){
            case 1:
rechercheLivre();
                break;
            case 2:
rechercheMagazine();
                break;
            case 3:
                System.out.println(CostumColor.PURPLE_BOLD_BRIGHT + "-----_____Exit MenuR_____------" + CostumColor.RESET);
                return;
            default:
                System.out.println(CostumColor.RED_BOLD_BRIGHT + "Invalid choice");
                break;
        }
    }while (true);
}
public void rechercheLivre(){
    int id=  InputValidator.getIntInput("Entre Recherche  livre ID :");
    livre.setId(id);
    livreDao.finId(livre);
}
public void rechercheMagazine(){
    int id=  InputValidator.getIntInput("Entre Recherche Magazine ID :");
    magazine.setId(id);
    magazinDao.finId(magazine);
}

}
