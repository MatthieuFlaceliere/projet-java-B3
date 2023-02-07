package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Motif;
import fr.esgi.pret_a_la_consomation.service.MotifService;

import java.util.ArrayList;
import java.util.List;

public class MotifServiceImpl implements MotifService {

    private static List<Motif> motifs = new ArrayList<>();
    @Override
    public Motif ajouterMotif(String nom, String description) {
        Motif motif = new Motif(nom, description);
        return ajouterMotif(motif);
    }

    @Override
    public Motif ajouterMotif(Motif motif) {
        motifs.add(motif);
        return motif;
    }

    @Override
    public List<Motif> recupererMotifs() {
        return motifs;
    }

    @Override
    public Motif recupererMotif(Long id) {
        for (Motif motif : motifs) {
            if (motif.getId().equals(id)) {
                return motif;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerMotif(Long id) {
        Motif motif = recupererMotif(id);
        if (motif==null) {
            return false;
        }
        else {
            return motifs.remove(motif);
        }
    }
}
