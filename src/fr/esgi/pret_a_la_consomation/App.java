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

public class App {
    private static final TauxService tauxService = new TauxServiceImpl();
    private static final MotifService motifService = new MotifServiceImpl();
    private static final DureeService dureeService = new DureeServiceImpl();
    private static final ClientService clientService = new ClientServiceImpl();
    private static final PretService pretService = new PretServiceImpl();
    private static final MensualiteService mensualiteService = new MensualiteServiceImpl();


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

        for (Taux taux : tauxService.recupererTauxs()) {
            System.out.println(taux.toStringConsole());
        }
        for (Client client : clientService.recupererClients()) {
            System.out.println(client.toStringConsole());
        }

        System.out.println(pretService.ajouterPret(1000,12, LocalDateTime.now(),LocalDate.of(2023,03,01),"",tauxService.recupererTaux(1L),clientService.recupererClient(1L)));

    }
}
