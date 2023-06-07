import it.kibo.fp.lib.RandomDraws;
import java.util.ArrayList;
import java.util.Random;

public class Grafo {
    public ArrayList<Nodo> nodi=new ArrayList<Nodo>();
    public int[][] matriceAdiacenza;
    private int posizioneFinale;



    public Grafo(int posizioneFinale) {
        this.posizioneFinale=posizioneFinale;
    }

    public Grafo(ArrayList <Nodo> nodiT) {
        nodi.addAll(nodiT);
        matriceAdiacenza = new int[4][4];
    }

    public void creaArco(int nodoA, int nodoB) {
        matriceAdiacenza[nodoA][nodoB] = 1;
        matriceAdiacenza[nodoB][nodoA] = 1;
    }

    public void Esplorazione() {
        int posizioneAttuale = 0;
        int posizioneFinale = nodi.size() - 1;
        int tentativi= 0;

        Personaggio personaggio= new Personaggio(20,5);

        while (posizioneAttuale != posizioneFinale) {
            Nodo nodoAttuale = nodi.get(posizioneAttuale);
            System.out.println("Nodo numero " + posizioneAttuale);

            if (posizioneAttuale != 0) {
                int incontroCasuale = RandomDraws.drawInteger(1, 2);
                if (incontroCasuale == 1) {
                    Mostro mostro = nodoAttuale.generaMostro();
                    Battaglia battaglia = new Battaglia(personaggio, mostro);
                    if (!battaglia.iniziaBattaglia()) {
                        tentativi++;
                        if (tentativi > 10) {
                            System.out.println("Hai superato i 10 tentativi. mi dispiace hai perso ");
                            return;

                        } else {
                            System.out.println("Hai perso contro il mostro. Riparti dall'inizio");
                            posizioneAttuale = 0;
                            personaggio.resetVitaAttacco();
                            continue;
                        }
                    }
                } else {
                    ModificatoreStatistica modificatore = nodoAttuale.generaModificatoreStatistica();
                    personaggio.applicaModificatore(modificatore);
                }
            }

            int prossimaPosizione = scegliProssimaPosizione(posizioneAttuale);
            if (prossimaPosizione != -1) {
                System.out.println("Nodo successivo " + prossimaPosizione);
                posizioneAttuale = prossimaPosizione;
            } else {
                System.out.println("Nodi finiti");
                posizioneAttuale--;
            }

        }
        System.out.println("Raggiunto nodo finale");
        Nodo nodoAttuale = nodi.get(posizioneAttuale);
        BossFinale bossFinale= new BossFinale(18,4);
        Battaglia battagliaFinale= new Battaglia(personaggio, bossFinale);

        bossFinale.subisciDannoVita(getRandomNumber(-5, 5));
        bossFinale.subisciDannoAttacco(getRandomNumber(-2, 2));
        System.out.println("Adesso dovrai abbattere il boss finale");


        if (battagliaFinale.iniziaBattaglia()) {
            System.out.println("Hai abbattuto il boss finale");
            personaggio.setVittoriaBossFinale();

        } else {
            System.out.println("Hai perso contro il boss finale. Riprova dal nodo iniziale");
            personaggio.resetVitaAttacco();
            Esplorazione();
        }
    }
    private int scegliProssimaPosizione(int posizioneAttuale) {
        int[] possibiliNodi = new int[5];
        int contatore = 0;
        for (int i = 0; i < 5; i++) {
            if (matriceAdiacenza[posizioneAttuale][i] == 1) {
                possibiliNodi[contatore] = i;
                contatore++;
            }
        }
        if (contatore > 0) {
            return possibiliNodi[getRandomNumber(0, contatore - 1)];
        } else {
            return -1;
        }
    }

    private int getRandomNumber (int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }





}
