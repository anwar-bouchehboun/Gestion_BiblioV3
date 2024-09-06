package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Document;

import java.util.HashMap;
import java.util.Optional;

public interface DocumentInterface <Doc extends Document> {
    void create(Doc document);
    Optional<Doc> finId(Integer  id);
    void update(Doc document);
    void delete(Doc document);
    HashMap<Integer, Doc> findAll();
    void DisplayData();
}
