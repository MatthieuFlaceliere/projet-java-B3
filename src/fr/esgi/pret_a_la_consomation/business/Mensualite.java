package fr.esgi.pret_a_la_consomation.business;

import java.time.LocalDate;
import java.util.Objects;

public class Mensualite {

    private Long id;
    private LocalDate datePrelevement;
    private double partInteretsRemboursement;
    private double partCapitalRemboursement;

    private static long compteur = 0L;

    // Constructeur
    public Mensualite() {
        id = ++compteur;
    }

    // Getters Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDatePrelevement() {
        return datePrelevement;
    }

    public void setDatePrelevement(LocalDate datePrelevement) {
        this.datePrelevement = datePrelevement;
    }

    public double getPartInteretsRemboursement() {
        return partInteretsRemboursement;
    }

    public void setPartInteretsRemboursement(double partInteretsRemboursement) {
        this.partInteretsRemboursement = partInteretsRemboursement;
    }

    public double getPartCapitalRemboursement() {
        return partCapitalRemboursement;
    }

    public void setPartCapitalRemboursement(double partCapitalRemboursement) {
        this.partCapitalRemboursement = partCapitalRemboursement;
    }

    // HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensualite that)) return false;
        return id == that.id && Double.compare(that.partInteretsRemboursement, partInteretsRemboursement) == 0 && Double.compare(that.partCapitalRemboursement, partCapitalRemboursement) == 0 && Objects.equals(datePrelevement, that.datePrelevement);
    }

    // Equal
    @Override
    public int hashCode() {
        return Objects.hash(id, datePrelevement, partInteretsRemboursement, partCapitalRemboursement);
    }

    // To string

    @Override
    public String toString() {
        return "Mensualite{" +
                "id=" + id +
                ", datePrelevement=" + datePrelevement +
                ", partInteretsRemboursement=" + partInteretsRemboursement +
                ", partCapitalRemboursement=" + partCapitalRemboursement +
                '}';
    }
}
