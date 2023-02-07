package fr.esgi.pret_a_la_consomation.business;

import java.util.ArrayList;
import java.util.Objects;

public class Client {

    private Long id;
    private String nom;
    private String prenom;
    private ArrayList<Pret> prets;
    private static long compteur = 0L;

    public Client(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        prets = new ArrayList<Pret>();
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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
        if (!(o instanceof Client client)) return false;
        return id == client.id && Objects.equals(nom, client.nom) && Objects.equals(prenom, client.prenom) && Objects.equals(prets, client.prets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, prets);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", prets=" + prets +
                '}';
    }

    public String toStringConsole(){
        return id + ". " + nom + " " + prenom;
    }
}
