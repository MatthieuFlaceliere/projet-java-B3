package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Client;
import fr.esgi.pret_a_la_consomation.business.Pret;
import fr.esgi.pret_a_la_consomation.business.Taux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PretService {
    /**
     * Ajout d'un pret à partir d'un montant demandé, d'une date de souscription, d'une date d'effet, d'une observation, d'un taux choisi et d'un client ciblé
     * @param montantDemande
     * @param dateSouscription
     * @param dateEffet
     * @param observations
     * @param taux
     * @param client
     * @return
     */
    Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Taux taux, Client client);

    /**
     * AJout d'un pret à partir d'un objet pret
     * @param pret
     * @return
     */
    Pret ajouterPret(Pret pret);

    /**
     * Récuperation d'une liste de tout les prets
     * @return
     */
    List<Pret> recupererPrets();

    /**
     * Récuperation d'un pret à partir de son id
     * @param id
     * @return
     */
    Pret recupererPret(Long id);

    /**
     * Suppression d'un pret à partir de son id
     * @param id
     * @return
     */
    boolean supprimerPret(Long id);

    /**
     * Tri des pret à partir d'un type
     * @param typeComparaison
     */
    void trierPret(String typeComparaison);

}
