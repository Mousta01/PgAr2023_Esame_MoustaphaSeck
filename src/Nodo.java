import it.kibo.fp.lib.RandomDraws;
import java.util.Random;

public class Nodo {


    public Mostro generaMostro() {
        int vitaMostro = RandomDraws.drawInteger(-5, 10);
        int attaccoMostro = RandomDraws.drawInteger(-3, 3);
        return new Mostro(vitaMostro, attaccoMostro);
    }
    public ModificatoreStatistica generaModificatoreStatistica() {
        int dannoVita = getRandomNumber(-5,10);
        int dannoAttacco = getRandomNumber(-3,3);
        return new ModificatoreStatistica(dannoVita, dannoAttacco);
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
}


