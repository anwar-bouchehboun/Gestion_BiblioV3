package org.gestionBibliothique.Metier.Interface;

import org.gestionBibliothique.Metier.Entite.Document;


import java.util.HashMap;
import java.util.Optional;

public interface DocumentInterface <Doc extends Document> {
    void create(Doc document);
    Optional<Doc> finId(Doc document);
    void update(Doc document);
    void delete(Doc document);
    HashMap<Integer, Doc> findAll();
    void DisplayData();
}
