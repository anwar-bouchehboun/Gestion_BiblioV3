package org.gestionBibliothique.Metier.Entite;

import org.gestionBibliothique.Utilitaire.LoggerMessage;

import java.time.LocalDate;

public class Emprunte {
    private Integer empruntId;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;
    private boolean emprunt_status ;
    private boolean reservation_status ;
    private Utilisateur utilisateur;
    private Document document;

    public Emprunte(Integer empruntId, LocalDate dateEmprunt, LocalDate dateRetour, boolean emprunt_status, boolean reservation_status, Utilisateur utilisateur, Document document) {
        this.empruntId = empruntId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.emprunt_status = emprunt_status;
        this.reservation_status = reservation_status;
        this.utilisateur = utilisateur;
        this.document = document;
    }

    public Emprunte(){

   }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public boolean isEmprunt_status() {
        return emprunt_status;
    }

    public void setEmprunt_status(boolean emprunt_status) {
        this.emprunt_status = emprunt_status;
    }

    public boolean isReservation_status() {
        return reservation_status;
    }

    public void setReservation_status(boolean reservation_status) {
        this.reservation_status = reservation_status;
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
