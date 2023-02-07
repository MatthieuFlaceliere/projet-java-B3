package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Duree;

import java.util.List;

public interface DureeService {

    Duree ajouterDuree(int dureeEnMois);
    Duree ajouterDuree(Duree duree);
    List<Duree> recupererDurees();
    Duree recupererDuree(Long id);
    boolean supprimerDuree(Long id);

}
