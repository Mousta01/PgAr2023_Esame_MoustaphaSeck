public class ModificatoreStatistica {
    final static String Descrizione_Dim_Vita= "Diminuzione della vita in un range tra -5 e 10";
    final static String Desrizione_Dim_Attacco= "Diminuzione dell'attacco in un range tra -3 e 3";
    private int vita;
    private int attacco;

    public ModificatoreStatistica(int vita, int attacco) {
        this.attacco=attacco;
        this.vita=vita;
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
}
