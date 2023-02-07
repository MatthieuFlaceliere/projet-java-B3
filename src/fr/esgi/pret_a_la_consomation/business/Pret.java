package fr.esgi.pret_a_la_consomation.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Pret {

    private Long id;
    private double montentDemande;
    private double montentMensualite;
    private LocalDateTime dateSouscription;
    private LocalDate dateEffet;
    private String observations;
    private ArrayList<Mensualite> mensualites;
    private static long compteur = 0L;

    public Pret() {
        mensualites = new ArrayList<>();
        id = ++compteur;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontentDemande() {
        return montentDemande;
    }

    public void setMontentDemande(double montentDemande) {
        this.montentDemande = montentDemande;
    }

    public double getMontentMensualite() {
        return montentMensualite;
    }

    public void setMontentMensualite(double montentMensualite) {
        this.montentMensualite = montentMensualite;
    }

    public LocalDateTime getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(LocalDateTime dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    public LocalDate getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(LocalDate dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pret pret)) return false;
        return id == pret.id && Double.compare(pret.montentDemande, montentDemande) == 0 && Double.compare(pret.montentMensualite, montentMensualite) == 0 && Objects.equals(dateSouscription, pret.dateSouscription) && Objects.equals(dateEffet, pret.dateEffet) && Objects.equals(observations, pret.observations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montentDemande, montentMensualite, dateSouscription, dateEffet, observations);
    }

    @Override
    public String toString() {
        return "Pret{" +
                "id=" + id +
                ", montentDemande=" + montentDemande +
                ", montentMensualite=" + montentMensualite +
                ", dateSouscription=" + dateSouscription +
                ", dateEffet=" + dateEffet +
                ", observations='" + observations + '\'' +
                '}';
    }

}
