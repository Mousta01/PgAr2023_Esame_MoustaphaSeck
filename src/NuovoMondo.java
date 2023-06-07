import java.util.ArrayList;
import java.util.Arrays;

public class NuovoMondo {
        private final int[][] grafo;
        private final int numNodi;

        public NuovoMondo(int numNodi) {
            this.numNodi = numNodi;
            grafo = new int[numNodi][numNodi];
        }

        public void aggiungiArco(int nodo1, int nodo2) {
            grafo[nodo1][nodo2] = 1;
            grafo[nodo2][nodo1] = 1;
        }

        public ArrayList<Integer> dijkstra(int nodoIniziale, int nodoFinale) {
            int[] distanze = new int[numNodi];
            boolean[] visitato = new boolean[numNodi];
            int[] predecessore = new int[numNodi];

            Arrays.fill(distanze, Integer.MAX_VALUE);
            Arrays.fill(visitato, false);
            Arrays.fill(predecessore, -1);

            distanze[nodoIniziale] = 0;

            for (int i = 0; i < numNodi - 1; i++) {
                int nodoCorrente = trovaNodoMinimoDistanza(distanze, visitato);
                visitato[nodoCorrente] = true;

                for (int nodo = 0; nodo < numNodi; nodo++) {
                    if (!visitato[nodo] && grafo[nodoCorrente][nodo] != 0 && distanze[nodoCorrente] != Integer.MAX_VALUE &&
                            distanze[nodoCorrente] + grafo[nodoCorrente][nodo] < distanze[nodo]) {
                        distanze[nodo] = distanze[nodoCorrente] + grafo[nodoCorrente][nodo];
                        predecessore[nodo] = nodoCorrente;
                    }
                }
            }

            return costruisciPercorso(nodoIniziale, nodoFinale, predecessore);
        }

        private int trovaNodoMinimoDistanza(int[] distanze, boolean[] visitato) {
            int minimo = Integer.MAX_VALUE;
            int nodoMinimo = -1;

            for (int nodo = 0; nodo < numNodi; nodo++) {
                if (!visitato[nodo] && distanze[nodo] < minimo) {
                    minimo = distanze[nodo];
                    nodoMinimo = nodo;
                }
            }

            return nodoMinimo;
        }

        private ArrayList<Integer> costruisciPercorso(int nodoIniziale, int nodoFinale, int[] predecessore) {
            ArrayList<Integer> percorso = new ArrayList<>();
            int nodoCorrente = nodoFinale;

            while (nodoCorrente != -1) {
                percorso.add(0, nodoCorrente);
                nodoCorrente = predecessore[nodoCorrente];
            }

            if (percorso.get(0) == nodoIniziale) {
                return percorso;
            } else {
                return new ArrayList<>();
            }
        }
    }





