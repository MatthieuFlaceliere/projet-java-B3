package fr.esgi.pret_a_la_consomation.util;

import java.util.Comparator;
import fr.esgi.pret_a_la_consomation.business.Pret;



public class ComparateurDePretsSurMontant implements Comparator<Pret> {
    /**
     * cette methode montre a java comment comparer 2 pret donné en parametre
     *
     * @param pret1 the first object to be compared.
     * @param pret2 the second object to be compared.
     */
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return Double.compare(pret2.getMontantDemande(), pret1.getMontantDemande());
    }
}
