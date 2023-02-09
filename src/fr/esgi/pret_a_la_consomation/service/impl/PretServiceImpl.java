package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Client;
import fr.esgi.pret_a_la_consomation.business.Pret;
import fr.esgi.pret_a_la_consomation.business.Taux;
import fr.esgi.pret_a_la_consomation.service.PretService;
import fr.esgi.pret_a_la_consomation.util.ComparateurDePretsSurMontant;
import fr.esgi.pret_a_la_consomation.util.ComparateurDePretsSurTaux;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PretServiceImpl implements PretService {
    private static List<Pret> prets = new ArrayList<>();
    @Override
    public Pret ajouterPret(double montentDemande, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Taux taux, Client client) {
        Pret pret = new Pret(montentDemande,dateSouscription,dateEffet,observations,taux,client);
        return ajouterPret(pret);
    }

    @Override
    public Pret ajouterPret(Pret pret) {
        prets.add(pret);
        return pret;
    }

    @Override
    public List<Pret> recupererPrets() {
        return prets;
    }

    @Override
    public Pret recupererPret(Long id) {
        for (Pret pret : prets) {
            if (pret.getId().equals(id)) {
                return pret;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerPret(Long id) {
        Pret pret = recupererPret(id);
        if (pret==null) {
            return false;
        }
        else {
            return prets.remove(pret);
        }
    }

    @Override
    public void trierPret(String typeComparaison) {
        //Utilisation d'un switch case car dans le future on peut imaginer plus de trie
        switch (typeComparaison){
            case "montant" -> prets.sort(new ComparateurDePretsSurMontant());
            case "taux" -> prets.sort(new ComparateurDePretsSurTaux());
        }
    }
}
