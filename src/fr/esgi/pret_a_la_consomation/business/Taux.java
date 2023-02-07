package fr.esgi.pret_a_la_consomation.business;

import java.util.ArrayList;
import java.util.Objects;

public class Taux {

    private Long id;
    private double valeur;
    private ArrayList<Pret> prets;
    private Duree duree;
    private Motif motif;
    private static long compteur = 0L;

    public Taux(double valeur, Duree duree, Motif motif) {
        this.valeur = valeur;
        this.duree = duree;
        this.motif = motif;
        prets = new ArrayList<>();
        id = ++compteur;
        duree.getTaux().add(this);
        motif.getTaux().add(this);
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

    public Duree getDuree() {
        return duree;
    }

    public void setDuree(Duree duree) {
        this.duree = duree;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Taux taux)) return false;
        return Double.compare(taux.valeur, valeur) == 0 && Objects.equals(id, taux.id) && Objects.equals(prets, taux.prets) && Objects.equals(duree, taux.duree) && Objects.equals(motif, taux.motif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valeur, prets, duree, motif);
    }

    @Override
    public String toString() {
        return "Taux{" +
                "id=" + id +
                ", valeur=" + valeur +
                ", prets=" + prets +
                ", duree=" + duree +
                ", motif=" + motif +
                '}';
    }

    public String toStringConsole(){
        return id + ". " + valeur + "% sur " + duree.getDureeEnMois() + " mois pour " + motif.getNom();
    }
}
