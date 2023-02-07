package fr.esgi.pret_a_la_consomation.business;

import java.util.ArrayList;
import java.util.Objects;

public class Taux {

    private Long id;
    private double valeur;
    private ArrayList<Pret> prets;
    private static long compteur = 0L;

    public Taux() {
        id = ++compteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public ArrayList<Pret> getPrets() {
        return prets;
    }

    public void setPrets(ArrayList<Pret> prets) {
        this.prets = prets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taux taux)) return false;
        return Double.compare(taux.valeur, valeur) == 0 && Objects.equals(id, taux.id) && Objects.equals(prets, taux.prets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valeur, prets);
    }

    @Override
    public String toString() {
        return "Taux{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", prets=" + prets +
                '}';
    }
}
