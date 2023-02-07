package fr.esgi.pret_a_la_consomation.service;

import fr.esgi.pret_a_la_consomation.business.Mensualite;
import fr.esgi.pret_a_la_consomation.business.Pret;

import java.time.LocalDate;
import java.util.List;

public interface MensualiteService {

    Mensualite ajouterMensualite(LocalDate datePrelevement, double partInteretsRemboursement, double partCapitalRemboursement, Pret pret);
    Mensualite ajouterMensualite(Mensualite mensualite);
    List<Mensualite> recupererMensualites();
    Mensualite recupererMensualite(Long id);
    boolean supprimerMensualite(Long id);

}
