package fr.esgi.pret_a_la_consomation.business;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;

public class Pret {

    private Long id;
    private double montantDemande;
    private double montantMensualite;
    private LocalDateTime dateSouscription;
    private LocalDate dateEffet;
    private String observations;
    private ArrayList<Mensualite> mensualites;
    private Taux taux;
    private Client client;
    private static long compteur = 0L;

    public Pret(double montantDemande, LocalDateTime dateSouscription, LocalDate dateEffet, String observations, Taux taux, Client client) {
        this.montantDemande = montantDemande;
        this.montantMensualite = calculeMensualite(montantDemande, taux);
        this.dateSouscription = dateSouscription;
        this.dateEffet = dateEffet;
        this.observations = observations;
        this.client = client;
        this.taux = taux;
        this.mensualites = new ArrayList<>();
        id = ++compteur;
        client.getPrets().add(this);
        taux.getPrets().add(this);
        calculeMensualites();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(double montantDemande) {
        this.montantDemande = montantDemande;
    }

    public double getMontantMensualite() {
        return montantMensualite;
    }

    public void setMontantMensualite(double montantMensualite) {
        this.montantMensualite = montantMensualite;
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
        return Double.compare(pret.montantDemande, montantDemande) == 0 && Double.compare(pret.montantMensualite, montantMensualite) == 0 && Objects.equals(id, pret.id) && Objects.equals(dateSouscription, pret.dateSouscription) && Objects.equals(dateEffet, pret.dateEffet) && Objects.equals(observations, pret.observations) && Objects.equals(mensualites, pret.mensualites) && Objects.equals(taux, pret.taux) && Objects.equals(client, pret.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, montantDemande, montantMensualite, dateSouscription, dateEffet, observations, mensualites, taux, client);
    }

    @Override
    public String toString() {
       String output ="""
        | id| montentDemande| mensualite| dateSouscription| dateEffet| taux| client|\s
        +------------+------------+------------+------------+------------+------------+------------+
        """;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        int col = 10;

        output = output.replaceAll("id", formatForTab(id.toString(), col));
        output = output.replaceAll("montentDemande", formatForTab(String.format("%.2f", montantDemande), col));
        output = output.replaceAll("dateSouscription", formatForTab(dateSouscription.format(dateFormat), col));
        output = output.replaceAll("dateEffet", formatForTab(dateEffet.format(dateFormat), col));
        output = output.replaceAll("mensualite", formatForTab(String.format("%.2f", montantMensualite), col));
        output = output.replaceAll("taux", formatForTab(String.format("%.2f",taux.getValeur()) + " %", col));
        output = output.replaceAll("client", formatForTab(client.getNom(), col));

        return output;
    }

    /*
    * Formate un string pour un tableau
     */
    private String formatForTab(String input, int colLargeur){
        for (int i = input.length(); i <= colLargeur; i++) {
            input += " ";
        }
        return input;
    }

    /*
    * mensualité = capital x i / ( 1 - (1+i) puissance -n )
        n: nombre de mensualités
        i: taux d’intérêt. Si le taux d’intérêt annuel est 5 %, i = 0,05/12 =0,004166
    * */
    private double calculeMensualite(double montantDemande, Taux taux){
        double mensualite = 0.0;
        int n = taux.getDuree().getDureeEnMois();
        double i = (taux.getValeur() / 100) / 12;

        mensualite = (montantDemande * i) / (1 - Math.pow(1 + i, -n));

        return mensualite;
    }

    /**
     * Calcule les mensualités pour le pret
     */
    private void calculeMensualites(){
        double interet = montantDemande * (taux.getValeur() / 100) / 12;
        Mensualite mensualite = new Mensualite(dateEffet , interet, (montantMensualite - interet), this);
        for (int i = 0; i < taux.getDuree().getDureeEnMois() - 1 ; i++) {
            Mensualite mensuPrecedante = mensualites.get(i);
            double reste = 0;
            reste = montantDemande - mensuPrecedante.getPartCapitalRemboursement();
            interet = reste * (taux.getValeur() / 100) / 12;
            double capitale = mensuPrecedante.getPartCapitalRemboursement() + montantMensualite - interet;
            mensualite = new Mensualite(dateEffet.plusMonths(i + 1) , interet, (mensuPrecedante.getPartCapitalRemboursement() + montantMensualite - interet), this);
        }
    }

}