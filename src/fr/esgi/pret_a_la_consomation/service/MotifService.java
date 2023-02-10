package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.*;

import java.util.List;

public interface MotifService {
    /**
     * Ajout d'un motif à partir d'un nom et d'une description
     * @param nom
     * @param description
     * @return
     */
    Motif ajouterMotif(String nom, String description);

    /**
     * AJout d'un motif à partir d'un bojet motif
     * @param motif
     * @return
     */
    Motif ajouterMotif(Motif motif);

    /**
     * Recuperation d'une liste de tous les motifs
     * @return
     */
    List<Motif> recupererMotifs();

    /**
     * Récuperation d'un motif à partir de son id
     * @param id
     * @return
     */
    Motif recupererMotif(Long id);

    /**
     * Suppression d'un motif à partir de son id
     * @param id
     * @return
     */
    boolean supprimerMotif(Long id);

}
