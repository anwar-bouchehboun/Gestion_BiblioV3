package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class Emprunte {
    private Integer empruntId;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private boolean status ;
    private Utilisateur utilisateur;
    private Document document;

    public Emprunte(int empruntId, LocalDate dateEmprunt, LocalDate dateRetour,boolean status, Utilisateur utilisateur,Document document) {
        this.empruntId = empruntId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.utilisateur = utilisateur;
        this.status=status;
        this.document=document;

    }
   public Emprunte(){

   }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getEmpruntId() {
        return empruntId;
    }
    public void setEmpruntId(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }



    public void setEmpruntId(int empruntId) {
        this.empruntId = empruntId;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public  void afficheDataEmprut(){
        LoggerMessage.info("Emprunt ID: " + empruntId + ", Date Emprunt: " + dateEmprunt +
                ", Date Retour: " + (dateRetour != null ? dateRetour : "Not Returned") +
                ", Utilisateur: " + utilisateur.getNom() + ", Type: " + utilisateur.getTypeUser() +
                ", Date Inscription: " + utilisateur.getDate_Insc());
    }

    @Override
    public String toString() {
        return "Emprunt ID: " + empruntId + ", Date Emprunt: " + dateEmprunt +
                ", Date Retour: " + (dateRetour != null ? dateRetour : "Not Returned") +
                ", Utilisateur: " + utilisateur.getNom() + ", Type: " + utilisateur.getTypeUser() +
                ", Date Inscription: " + utilisateur.getDate_Insc();
    }
}
