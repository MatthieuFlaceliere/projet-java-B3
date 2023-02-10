package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Mensualite;
import fr.esgi.pret_a_la_consomation.business.Pret;

import java.time.LocalDate;
import java.util.List;

public interface MensualiteService {
    /**
     * Ajout d'une nouvelle mensualité à partir d'une date de prélèvement, d'un montant d'intérêt, d'un capital de remboursement
     * et d'un objet pret ciblé
     * @param datePrelevement
     * @param partInteretsRemboursement
     * @param partCapitalRemboursement
     * @param pret
     * @return
     */
    Mensualite ajouterMensualite(LocalDate datePrelevement, double partInteretsRemboursement, double partCapitalRemboursement, Pret pret);

    /**
     * AJout d'une nouvelle mensualité à partir d'un objet mensualité
     * @param mensualite
     * @return
     */
    Mensualite ajouterMensualite(Mensualite mensualite);

    /**
     * Récupération d'une liste de toute les mensualités
     * @return
     */
    List<Mensualite> recupererMensualites();

    /**
     * Récupération d'une mensualité à partir de son id
     * @param id
     * @return
     */
    Mensualite recupererMensualite(Long id);

    /**
     * Suppression d'une mensualité à partir de son id
     * @param id
     * @return
     */
    boolean supprimerMensualite(Long id);

}
