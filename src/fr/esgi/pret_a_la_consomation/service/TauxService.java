package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Duree;
import fr.esgi.pret_a_la_consomation.business.Motif;
import fr.esgi.pret_a_la_consomation.business.Taux;

import java.util.List;

public interface TauxService {
    Taux ajouterTaux(double valeur, Duree duree, Motif motif);
    Taux ajouterTaux(Taux taux);
    List<Taux> recupererTauxs();
    Taux recupererTaux(Long id);
    boolean supprimerTaux(Long id);

}
