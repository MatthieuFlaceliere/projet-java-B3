package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Duree;
import fr.esgi.pret_a_la_consomation.business.Motif;
import fr.esgi.pret_a_la_consomation.business.Taux;

import java.util.List;

public interface TauxService {
    /**
     * Ajout d'un taux à partir d'une valeur, d'une durée et d'un motif
     * @param valeur
     * @param duree
     * @param motif
     * @return
     */
    Taux ajouterTaux(double valeur, Duree duree, Motif motif);

    /**
     * Ajout d'un taux à partir d'un objet taux
     * @param taux
     * @return
     */
    Taux ajouterTaux(Taux taux);

    /**
     * Récuperation d'une liste de tout les taux
     * @return
     */
    List<Taux> recupererTauxs();

    /**
     * Récuperation d'un taux à partir de son id
     * @param id
     * @return
     */
    Taux recupererTaux(Long id);

    /**
     * Suppression d'un taux à partir de son id
     * @param id
     * @return
     */
    boolean supprimerTaux(Long id);

}
