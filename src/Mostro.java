public class Mostro {
    private int vita;
    private int attacco;

    public Mostro(int vita, int attacco) {
        this.vita=vita;
        this.attacco=attacco;
    }

    public int getVita() {
        return vita;
    }

    public void setVita(int vita) {
        this.vita = vita;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public void subisciDanno(int danno) {
        vita -= danno;
        System.out.println("Il mostro subisce " + danno + " danni. Vita rimanente: " + vita);
    }
}
