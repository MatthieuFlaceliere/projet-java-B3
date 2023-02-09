package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Client;
import fr.esgi.pret_a_la_consomation.business.Pret;
import fr.esgi.pret_a_la_consomation.business.Taux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface PretService {

    Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Taux taux, Client client);
    Pret ajouterPret(Pret pret);
    List<Pret> recupererPrets();
    Pret recupererPret(Long id);
    boolean supprimerPret(Long id);
    void trierPret(String typeComparaison);

}
