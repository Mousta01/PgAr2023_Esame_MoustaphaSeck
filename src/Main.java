import it.kibo.fp.lib.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Personaggio personaggio = new Personaggio(20, 5);

        Grafo grafo = new Grafo(4);

        // Creazione dei nodi del grafo
        Nodo nodoA = new Nodo();
        Nodo nodoB = new Nodo();
        Nodo nodoC = new Nodo();
        Nodo nodoD = new Nodo();
        Nodo nodoFinale = new Nodo();

        // Aggiunta dei nodi alla lista del grafo
        grafo.nodi.add(nodoA);
        grafo.nodi.add(nodoB);
        grafo.nodi.add(nodoC);
        grafo.nodi.add(nodoD);
        grafo.nodi.add(nodoFinale);

        // Creazione degli archi del grafo
        grafo.creaArco(0, 1);
        grafo.creaArco(0, 2);
        grafo.creaArco(1, 3);
        grafo.creaArco(2, 3);
        grafo.creaArco(3, 4);

        // Esecuzione dell'esplorazione del grafo
        grafo.Esplorazione();


        while (true) {
            if (personaggio.haVintoBossFinale()) {
                System.out.println("Congratulazioni! hai sconfitto il boss Finale");
                Scanner scanner = new Scanner(System.in);
                Grafo nuovoMondo = new Grafo(7);
                boolean exit = false;

                while (!exit) {
                    System.out.println("Menu:");
                    System.out.println("1. Esplora Nuovo Mondo");
                    System.out.println("2. Exit");

                    int scelta = scanner.nextInt();
                    if (scelta == 1) {

                        System.out.println("Percorso più breve nel Nuovo Mondo :" );
                    } else if (scelta == 2){
                        System.out.println("arrivederci.");
                        break;
                    } else {
                        System.out.println("Scelta non valida. Riprova.");

                    }
                }
            }

                NuovoMondo nuovoMondo = new NuovoMondo (7);
                nuovoMondo.aggiungiArco(0, 1);
                nuovoMondo.aggiungiArco(0, 3);
                nuovoMondo.aggiungiArco(1, 2);
                nuovoMondo.aggiungiArco(1, 4);
                nuovoMondo.aggiungiArco(2, 5);
                nuovoMondo.aggiungiArco(3, 4);
                nuovoMondo.aggiungiArco(4, 5);
                nuovoMondo.aggiungiArco(4, 6);
                nuovoMondo.aggiungiArco(5, 6);

            }


        }
    }





