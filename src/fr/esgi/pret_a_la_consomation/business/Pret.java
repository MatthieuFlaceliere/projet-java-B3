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
    private Taux taux;
    private Client client;
    private static long compteur = 0L;

    public Pret(double montentDemande, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Taux taux, Client client) {
        this.montentDemande = montentDemande;
        this.montentMensualite = calculeMensualite(montentDemande, taux);
        this.dateSouscription = dateSouscription;
        this.dateEffet = dateEffet;
        this.observations = observations;
        this.client = client;
        this.taux = taux;
        this.mensualites = new ArrayList<>();
        id = ++compteur;
        client.getPrets().add(this);
        taux.getPrets().add(this);
    }

    public Long getId() {
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

    public ArrayList<Mensualite> getMensualites() {
        return mensualites;
    }

    public void setMensualites(ArrayList<Mensualite> mensualites) {
        this.mensualites = mensualites;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pret pret)) return false;
        return Double.compare(pret.montentDemande, montentDemande) == 0 && Double.compare(pret.montentMensualite, montentMensualite) == 0 && Objects.equals(id, pret.id) && Objects.equals(dateSouscription, pret.dateSouscription) && Objects.equals(dateEffet, pret.dateEffet) && Objects.equals(observations, pret.observations) && Objects.equals(mensualites, pret.mensualites) && Objects.equals(taux, pret.taux) && Objects.equals(client, pret.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montentDemande, montentMensualite, dateSouscription, dateEffet, observations, mensualites, taux, client);
    }

    @Override
    public String toString() {
        return "Pret{" +
                "id=" + id +
                ", montentDemande=" + montentDemande +
                ", montentMensualite=" + String.format("%.2f", montentMensualite) +
                ", dateSouscription=" + dateSouscription +
                ", dateEffet=" + dateEffet +
                ", observations='" + observations +
                ", mensualites=" + mensualites +
                ", taux={id = " + taux.getId() + ", Valeur = " + taux.getValeur() + '}' +
                ", client{id = " + client.getId() + "Nom = " + client.getNom() + ", Prenom = " + client.getPrenom() + "}}";
    }

    /*
    * mensualité = capital x i / ( 1 - (1+i) puissance -n )
        n: nombre de mensualités
        i: taux d’intérêt. Si le taux d’intérêt annuel est 5 %, i = 0,05/12 =0,004166
    * */
    private double calculeMensualite(double montentDemande, Taux taux){
        double mensualite = 0.0;
        int n = taux.getDuree().getDureeEnMois();
        double i = (taux.getValeur() / 100) / 12;

        mensualite = (montentDemande * i) / (1 - Math.pow(1 + i, -n));

        return mensualite;
    }

}