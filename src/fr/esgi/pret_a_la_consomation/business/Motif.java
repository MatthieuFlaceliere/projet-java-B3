package fr.esgi.pret_a_la_consomation.business;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class Motif {

    private Long id;
    private String nom;
    private String description;
    private ArrayList<Taux> taux;
    private static long compteur = 0L;

    public Motif() {
        id = ++compteur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof Motif motif)) return false;
        return Objects.equals(id, motif.id) && Objects.equals(nom, motif.nom) && Objects.equals(description, motif.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, description);
    }

    @Override
    public String toString() {
        return "Motif{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
