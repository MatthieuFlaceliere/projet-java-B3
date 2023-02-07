package fr.esgi.pret_a_la_consomation.business;

import java.util.ArrayList;
import java.util.Objects;

public class Duree {

    private Long id;
    private int dureeEnMois;
    private ArrayList<Taux> taux;
    private static long compteur = 0L;

    public Duree() {
        id = ++compteur;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public ArrayList<Taux> getTaux() {
        return taux;
    }

    public void setTaux(ArrayList<Taux> taux) {
        this.taux = taux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duree duree)) return false;
        return id == duree.id && dureeEnMois == duree.dureeEnMois;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dureeEnMois);
    }

    @Override
    public String toString() {
        return "Duree{" +
                "id=" + id +
                ", dureeEnMois=" + dureeEnMois +
                ", taux=" + taux +
                '}';
    }
}
