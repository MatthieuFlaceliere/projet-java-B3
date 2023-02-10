package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Client;

import java.util.List;

public interface ClientService {
    /**
     * Ajout d'un client à partir du nom et du prénom
     * @param nom
     * @param prenom
     * @return
     */
    Client ajouterClient(String nom, String prenom);

    /**
     * Ajout d'un client à partir d'un objet Client
     * @param client
     * @return
     */
    Client ajouterClient(Client client);

    /**
     * Récuperation d'une liste de tout les clients
     * @return
     */
    List<Client> recupererClients();

    /**
     * Récuperation d'un client à partir de son id
     * @param id
     * @return
     */
    Client recupererClient(Long id);

    /**
     * Suppression d'un client à partir de son id
     * @param id
     * @return
     */
    boolean supprimerClient(Long id);
}
