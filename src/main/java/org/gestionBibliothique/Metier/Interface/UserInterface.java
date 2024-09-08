package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Document;
import org.gestionBibliothique.Metier.Entite.Utilisateur;

import java.util.HashMap;
import java.util.Optional;

public interface UserInterface <User extends Utilisateur> {
        void create(User utilisateur);
        Optional<User> finId(User utilisateur);
        void update(User utilisateur);
        void delete(User utilisateur);
        HashMap<Integer, User> findAll();
        void DisplayData();
        Integer profId(User utilisateur);

}
