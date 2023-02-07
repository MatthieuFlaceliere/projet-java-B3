package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Client;

import java.util.List;

public interface ClientService {
    Client ajouterClient(String nom, String prenom);
    Client ajouterClient(Client client);
    List<Client> recupererClients();
    Client recupererClient(Long id);
    boolean supprimerClient(Long id);
}
