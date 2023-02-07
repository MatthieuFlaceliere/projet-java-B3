package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Client;
import fr.esgi.pret_a_la_consomation.service.ClientService;

import java.util.ArrayList;
import java.util.List;

public class ClientServiceImpl implements ClientService {
    private static List<Client> clients = new ArrayList<>();
    @Override
    public Client ajouterClient(String nom, String prenom) {
        Client client = new Client(nom, prenom);
        return ajouterClient(client);
    }

    @Override
    public Client ajouterClient(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> recupererClients() {
        return clients;
    }

    @Override
    public Client recupererClient(Long id) {
        for (Client client : clients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerClient(Long id) {
        Client client = recupererClient(id);
        if (client==null) {
            return false;
        }
        else {
            return clients.remove(client);
        }
    }
}
