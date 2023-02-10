package fr.esgi.pret_a_la_consomation.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Mensualite {

    private Long id;
    private LocalDate datePrelevement;
    private double partInteretsRemboursement;
    private double partCapitalRemboursement;
    private Pret pret;
    private static long compteur = 0L;

    // Constructeur
    public Mensualite(LocalDate datePrelevement, double partInteretsRemboursement, double partCapitalRemboursement, Pret pret) {
        this.datePrelevement = datePrelevement;
        this.partInteretsRemboursement = partInteretsRemboursement;
        this.partCapitalRemboursement = partCapitalRemboursement;
        this.pret = pret;
        id = ++compteur;
        pret.getMensualites().add(this);
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

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensualite that)) return false;
        return Double.compare(that.partInteretsRemboursement, partInteretsRemboursement) == 0 && Double.compare(that.partCapitalRemboursement, partCapitalRemboursement) == 0 && Objects.equals(id, that.id) && Objects.equals(datePrelevement, that.datePrelevement) && Objects.equals(pret, that.pret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, datePrelevement, partInteretsRemboursement, partCapitalRemboursement, pret);
    }

    // To string

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        return datePrelevement.format(formatter) + "    " + String.format("%.2f", partCapitalRemboursement) + "                  " + String.format("%.2f", partInteretsRemboursement);
    }
}
