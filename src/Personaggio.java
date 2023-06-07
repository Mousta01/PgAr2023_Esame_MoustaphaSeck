public class Personaggio {
    private int vita;
    private int attacco;
    private boolean vittoriaBossFinale;

    public Personaggio(int vita, int attacco) {
        this.vita=vita;
        this.attacco=attacco;
    }

    public int getVita() {
        return vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setVittoriaBossFinale() {
        vittoriaBossFinale= true;
    }

    public boolean haVintoBossFinale() {
        if (vita <= 0) {
            return false;
        }
        return true;
    }

    public void subisciDanno(int danno) {
        vita -= danno;
        System.out.println("Il personaggio subisce " + danno + " danni. Vita rimanente: " + vita);
    }

    public void resetVitaAttacco() {
        vita = 20;
        attacco= 5;
    }

    public void applicaModificatore(ModificatoreStatistica modificatore) {
        vita += modificatore.getVita();
        attacco += modificatore.getAttacco();
        System.out.println("Il personaggio ha ottenuto un modificatore di statistica.");
        System.out.println("Vita aggiornata: " + vita + ", Attacco aggiornato: " + attacco);
    }
}
