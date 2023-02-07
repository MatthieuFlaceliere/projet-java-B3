package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.*;

import java.util.List;

public interface MotifService {

    Motif ajouterMotif(String nom, String description);
    Motif ajouterMotif(Motif motif);
    List<Motif> recupererMotifs();
    Motif recupererMotif(Long id);
    boolean supprimerMotif(Long id);

}
