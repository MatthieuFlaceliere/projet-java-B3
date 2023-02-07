package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Duree;
import fr.esgi.pret_a_la_consomation.business.Motif;
import fr.esgi.pret_a_la_consomation.business.Taux;
import fr.esgi.pret_a_la_consomation.business.Taux;
import fr.esgi.pret_a_la_consomation.service.TauxService;

import java.util.ArrayList;
import java.util.List;

public class TauxServiceImpl implements TauxService {

    private static List<Taux> tauxList = new ArrayList<>();
    @Override
    public Taux ajouterTaux(double valeur, Duree duree, Motif motif) {
        Taux taux = new Taux(valeur, duree,motif);
        return ajouterTaux(taux);
    }

    @Override
    public Taux ajouterTaux(Taux taux) {
        tauxList.add(taux);
        return taux;
    }

    @Override
    public List<Taux> recupererTauxs() {
        return tauxList;
    }

    @Override
    public Taux recupererTaux(Long id) {
        for (Taux taux : tauxList) {
            if (taux.getId().equals(id)) {
                return taux;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerTaux(Long id) {
        Taux taux = recupererTaux(id);
        if (taux==null) {
            return false;
        }
        else {
            return tauxList.remove(taux);
        }
    }
}
