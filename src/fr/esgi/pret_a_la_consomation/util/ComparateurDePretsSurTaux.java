package fr.esgi.pret_a_la_consomation.util;

import fr.esgi.pret_a_la_consomation.business.Pret;

import java.util.Comparator;


public class ComparateurDePretsSurTaux implements Comparator<Pret> {
    /**
     * Cette methode montre à java comment comparer deux pret donnés en parametre
     *
     * @param pret1 the first object to be compared.
     * @param pret2 the second object to be compared.
     * @return
     */
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return Double.compare(pret2.getTaux().getValeur(), pret1.getTaux().getValeur());
    }
}
