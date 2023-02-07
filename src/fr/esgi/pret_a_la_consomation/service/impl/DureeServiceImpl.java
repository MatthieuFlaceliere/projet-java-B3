package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Duree;
import fr.esgi.pret_a_la_consomation.service.DureeService;

import java.util.ArrayList;
import java.util.List;

public class DureeServiceImpl implements DureeService {
    private static List<Duree> durees = new ArrayList<>();
    @Override
    public Duree ajouterDuree(int dureeEnMois) {
        Duree duree = new Duree(dureeEnMois);
        return ajouterDuree(duree);
    }

    @Override
    public Duree ajouterDuree(Duree duree) {
        durees.add(duree);
        return duree;
    }

    @Override
    public List<Duree> recupererDurees() {
        return durees;
    }

    @Override
    public Duree recupererDuree(Long id) {
        for (Duree duree : durees) {
            if (duree.getId().equals(id)) {
                return duree;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerDuree(Long id) {
        Duree duree = recupererDuree(id);
        if (duree==null) {
            return false;
        }
        else {
            return durees.remove(duree);
        }
    }
}
