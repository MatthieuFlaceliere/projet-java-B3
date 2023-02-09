package fr.esgi.pret_a_la_consomation;

import fr.esgi.pret_a_la_consomation.business.*;
import fr.esgi.pret_a_la_consomation.service.*;
import fr.esgi.pret_a_la_consomation.service.impl.*;
import fr.esgi.pret_a_la_consomation.util.ComparateurDePretsSurMontant;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

        //Aprer initialisation des clients et taux
        menuPrincipal();

        for (Taux taux : tauxService.recupererTauxs()) {
            System.out.println(taux.toStringConsole());
        }
        for (Client client : clientService.recupererClients()) {
            System.out.println(client.toStringConsole());
        }


        System.out.println(pretService.ajouterPret(1000, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(1L), clientService.recupererClient(1L)));
        System.out.println(pretService.ajouterPret(1200, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(2L), clientService.recupererClient(1L)));
        System.out.println(pretService.ajouterPret(1300, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(1L), clientService.recupererClient(1L)));
        System.out.println(pretService.ajouterPret(1400, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(2L), clientService.recupererClient(1L)));
        pretService.trierPret("taux");
        System.out.println(pretService.recupererPrets());

    }

    /*
    * Menu principal
    */
    private static void menuPrincipal(){
        byte selection = 0;
        System.out.println("""
        Bienvenue sur prêt à la consommation\s
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
        // Améliorer l'affichage
        System.out.println(pretService.recupererPrets());
    }

    /*
     * Affichage pour ajouter un pret
     */
    private static void affichageAjoutPret(){
        affichageClients();
        System.out.println("Veuillez saisir l'id du client concerné : ");
        //TODO
        System.out.println("Veuillez saisir le montant demandé : ");
        //TODO
        affichageTaux();
        System.out.println("Veuillez saisir l'id du taux annuel : ");
        //TODO
        System.out.println("Veuillez saisir la date d'effet au format MM/yyyy : ");
        //TODO
        Pret newPret = new Pret(1000, LocalDateTime.now(), LocalDate.of(2023, 03, 01), "", tauxService.recupererTaux(1L), clientService.recupererClient(1L));
        pretService.ajouterPret(newPret);
        affichagePret(newPret);
    }

    /*
    *   Affichage des prets entre deux dates
    */
    private static void affichageDatesPrets(){

    }

    /*
     * Affichage des clients
     */
    private static void affichageClients(){

    }

    /*
     * Affichage des taux
     */
    private static void affichageTaux(){

    }

    /*
    * Affichage en détail d'un prêts
    */
    private static void affichagePret(Pret pret){
        System.out.println(pret);
    }
}
