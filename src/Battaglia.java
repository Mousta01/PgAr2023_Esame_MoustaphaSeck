public class Battaglia {
    private Personaggio personaggio;
    private Mostro mostro;
    private BossFinale bossFinale;


    public Battaglia(Personaggio personaggio, Mostro mostro) {
        this.personaggio=personaggio;
        this.mostro=mostro;

    }

    public Battaglia (Personaggio personaggio, BossFinale bossFinale) {
        this.personaggio=personaggio;
        this.bossFinale=bossFinale;
    }

    public boolean iniziaBattaglia() {
        System.out.println("Hai incontrato un mostro!");
        System.out.println("Inizia la battaglia tra il personaggio e il mostro.");

        while (personaggio.getVita() > 0 && mostro.getVita() > 0) {
            // Turno del personaggio
            int dannoPersonaggio = personaggio.getAttacco();
            mostro.subisciDanno(dannoPersonaggio);

            // Verifica se il mostro è stato sconfitto
            if (mostro.getVita() <= 0) {
                System.out.println("Vincitore duello");
                return true;
            }

            // Turno del mostro
            int dannoMostro = mostro.getAttacco();
            personaggio.subisciDanno(dannoMostro);

            // Verifica se il personaggio è stato sconfitto
            if (personaggio.getVita() <= 0) {
                System.out.println("Sei stato sconfitto!");
                return false;
            }
        }

        return false;
    }


}

