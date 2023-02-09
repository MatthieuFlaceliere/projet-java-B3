package fr.esgi.pret_a_la_consomation;

import fr.esgi.pret_a_la_consomation.business.*;
import fr.esgi.pret_a_la_consomation.service.*;
import fr.esgi.pret_a_la_consomation.service.impl.*;
import fr.esgi.pret_a_la_consomation.util.ComparateurDePretsSurMontant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final TauxService tauxService = new TauxServiceImpl();
    private static final MotifService motifService = new MotifServiceImpl();
    private static final DureeService dureeService = new DureeServiceImpl();
    private static final ClientService clientService = new ClientServiceImpl();
    private static final PretService pretService = new PretServiceImpl();
    private static final MensualiteService mensualiteService = new MensualiteServiceImpl();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //Initialisation des données
        Init();

        //Après initialisation des clients et taux
        System.out.print("Bienvenue sur prêt à la consommation\n");
        menuPrincipal();

    }
    /*
    * Data initilization
     */
    private static void Init() {
        motifService.ajouterMotif("Moto", "Moto desc");
        motifService.ajouterMotif("Auto", "Auto desc");

        dureeService.ajouterDuree(24);
        dureeService.ajouterDuree(12);

        for (int i = 1; i < 5; i++) {
            tauxService.ajouterTaux(0.5 * ( i + 1 ),dureeService.recupererDurees().get(i % 2),motifService.recupererMotifs().get(i <=2 ? 1 : 0));
        }

        for (int i = 0; i < 5; i++) {
            clientService.ajouterClient("Nom" + i, "Prenom" + i);
        }

        pretService.ajouterPret(1000, LocalDateTime.now(), LocalDate.of(2021, 03, 01), "", tauxService.recupererTaux(1L), clientService.recupererClient(1L));
        pretService.ajouterPret(1600, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(2L), clientService.recupererClient(2L));
        pretService.ajouterPret(1300, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(3L), clientService.recupererClient(3L));
        pretService.ajouterPret(1400, LocalDateTime.now(), LocalDate.of(2021, 03, 01), "", tauxService.recupererTaux(3L), clientService.recupererClient(4L));
    }

    /*
    * Menu principal
    */
    private static void menuPrincipal(){
        byte selection = 0;
        System.out.println("""
        1. Voir tous les prêts triées par montant (du plus élevé au plus petit)
        2. Voir tous les prêts triées par taux (du plus élevé au plus petit)\s
        3. Voir la liste des prêts qui débutent entre deux dates données\s
        4. Ajouter un prêt
        5. Quitter \s
        """);
        do {
            try {
                System.out.print("Faîtes votre choix : ");
                selection = Byte.parseByte(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Saisie invalide");
            }
        } while (selection < 1 || selection > 5);
        switch (selection) {
            case 1 -> affichageTriesPrets("montant");
            case 2 -> affichageTriesPrets("taux");
            case 3 -> affichageDatesPrets();
            case 4 -> affichageAjoutPret();
        }
    }

    /*
     * Affichage des prêts avec des tries ou des date données
     */
    private static void affichageTriesPrets(String trie){
        pretService.trierPret(trie);
        switch (trie){
            case "montant" -> System.out.println("""
                   +------------+------------+------------+------------+------------+------------+------------+
                   | Num pret   | Montant ↑  | Mensualité |Souscription| Date effet | Taux       | Client     |
                   +------------+------------+------------+------------+------------+------------+------------+""");
            case "taux" -> System.out.println("""
                   +------------+------------+------------+------------+------------+------------+------------+
                   | Num pret   | Montant    | Mensualité |Souscription| Date effet | Taux ↑     | Client     |
                   +------------+------------+------------+------------+------------+------------+------------+""");
        }

        for ( Pret pret: pretService.recupererPrets()) {
            System.out.print(pret);
        }

        menuPrincipal();
    }

    /*
     * Affichage pour ajouter un pret
     */
    private static void affichageAjoutPret(){
        affichageClients();
        System.out.println("Veuillez saisir l'id du client concerné : ");
        String inputIdClient = sc.nextLine();
        Long idClient = Long.parseLong(inputIdClient);
        Client client = clientService.recupererClient(idClient);

        System.out.println("Veuillez saisir le montant demandé : ");
        String inputMontantDemande = sc.nextLine();
        Double montantDemande = Double.parseDouble(inputMontantDemande);

        affichageTaux();
        System.out.println("Veuillez saisir l'id du taux annuel : ");
        String inputIdTauxAnnuel = sc.nextLine();
        Long idTauxAnnuel = Long.parseLong(inputIdTauxAnnuel);
        Taux taux = tauxService.recupererTaux(idTauxAnnuel);

        System.out.println("Veuillez saisir la date d'effet au format dd/MM/yyyy : ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String inputDateEffet = sc.nextLine();
        LocalDate dateEffet = LocalDate.parse(inputDateEffet, formatter);

        Pret newPret = new Pret(montantDemande, LocalDateTime.now(), dateEffet, "", taux, client);
        pretService.ajouterPret(newPret);
        affichagePret(newPret);
    }

    /*
    *   Affichage des prets entre deux dates
    */
    private static void affichageDatesPrets(){
        System.out.println("Veuillez saisir la date de début au format dd/MM/yyyy : ");
        String inputDateDebut = sc.nextLine();
        System.out.println("Veuillez saisir la date de fin au format dd/MM/yyyy : ");
        String inputDateFin = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateDebut = LocalDate.parse(inputDateDebut, formatter);
        LocalDate dateFin = LocalDate.parse(inputDateFin, formatter);
        List<Pret> listPret = pretService.recupererPrets().stream()
                .filter(pret -> pret.getDateEffet().isAfter(dateDebut) && pret.getDateEffet().isBefore(dateFin))
                .toList();
        System.out.println("Voici les prêts ayant pris effet entre le : " + inputDateDebut + " et le : " + inputDateFin);
        System.out.println("""
                   +------------+------------+------------+------------+------------+------------+------------+
                   | Num pret   | Montant    | Mensualité |Souscription| Date effet | Taux       | Client     |
                   +------------+------------+------------+------------+------------+------------+------------+""");
        for ( Pret pret: listPret) {
            System.out.print(pret);
        }

        menuPrincipal();
    }

    /*
     * Affichage des clients
     */
    private static void affichageClients(){
        List<Client> listClients = clientService.recupererClients();
        for (Client client:listClients) {
            System.out.println(client.toStringConsole());
        }
    }

    /*
     * Affichage des taux
     */
    private static void affichageTaux(){
        List<Taux> listTaux = tauxService.recupererTauxs();
        for (Taux taux:listTaux) {
            System.out.println(taux.toStringConsole());
        }
    }

    /*
    * Affichage en détail d'un prêts
    */
    private static void affichagePret(Pret pret){
        System.out.println("Voici les détails du prêt : id : "+ pret.getClient().getId() +", client : " + pret.getClient().getNom() +" "+ pret.getClient().getPrenom() + ", montant emprunté : "+ pret.getMontentDemande() +", mensualité : " + pret.getMontentMensualite());
        menuPrincipal();
    }
}
