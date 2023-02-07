package fr.esgi.pret_a_la_consomation.service.impl;

import fr.esgi.pret_a_la_consomation.business.Mensualite;
import fr.esgi.pret_a_la_consomation.business.Pret;
import fr.esgi.pret_a_la_consomation.service.MensualiteService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MensualiteServiceImpl implements MensualiteService {
    private static List<Mensualite> mensualites = new ArrayList<>();
    @Override
    public Mensualite ajouterMensualite(LocalDate datePrelevement, double partInteretsRemboursement, double partCapitalRemboursement, Pret pret) {
        Mensualite mensualite = new Mensualite(datePrelevement, partInteretsRemboursement,partCapitalRemboursement,pret);
        return ajouterMensualite(mensualite);
    }

    @Override
    public Mensualite ajouterMensualite(Mensualite mensualite) {
        mensualites.add(mensualite);
        return mensualite;
    }

    @Override
    public List<Mensualite> recupererMensualites() {
        return mensualites;
    }

    @Override
    public Mensualite recupererMensualite(Long id) {
        for (Mensualite mensualite : mensualites) {
            if (mensualite.getId().equals(id)) {
                return mensualite;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerMensualite(Long id) {
        Mensualite mensualite = recupererMensualite(id);
        if (mensualite==null) {
            return false;
        }
        else {
            return mensualites.remove(mensualite);
        }
    }
}
