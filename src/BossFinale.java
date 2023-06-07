public class BossFinale {
    private int vita;
    private int attacco;

    public BossFinale (int vita, int attacco ) {
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

    public void subisciDannoVita(int danno) {
        vita -= danno;
        if (vita < 0) {
            vita = 0;
        }
    }

    public void subisciDannoAttacco(int danno) {
        attacco -= danno;
        if (attacco < 0) {
            attacco = 0;
        }
    }
}
