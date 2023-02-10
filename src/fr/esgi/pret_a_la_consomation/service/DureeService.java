package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Duree;

import java.util.List;

public interface DureeService {
    /**
     * Ajout d'une durée à partir d'un nombre de mois
     * @param dureeEnMois
     * @return
     */
    Duree ajouterDuree(int dureeEnMois);

    /**
     * Ajout d'une durée à partir d'un objet durée
     * @param duree
     * @return
     */
    Duree ajouterDuree(Duree duree);

    /**
     * Récupération d'une liste de toutes les Durées
     * @return
     */
    List<Duree> recupererDurees();

    /**
     * Récupération d'une durée à partir de son id
     * @param id
     * @return
     */
    Duree recupererDuree(Long id);

    /**
     * Suppression d'une durée à partir de son id
     * @param id
     * @return
     */
    boolean supprimerDuree(Long id);

}
