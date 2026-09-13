package vlny;

import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Ork;

import java.util.ArrayList;

/**
 * Spravuje vlny nepriateľov v hre.
 */
public class VlnaManager {
    private final int pocetVln;
    private int cisloAktualnejVlny;
    private final ArrayList<Vlna> vlny;

    /**
     * Vytvorí VlnaManager s preddefinovanými vlnami nepriateľov.
     * Každá vlna obsahuje rôzne kombinácie Goblinov a Orkov.
     */
    public VlnaManager() {
        this.cisloAktualnejVlny = 0;
        this.vlny = new ArrayList<>();

        Vlna lahkaVlna = new Vlna(1, new Goblin(), new Goblin(), new Goblin(), new Goblin());
        Vlna strednaVlna = new Vlna(2, new Goblin(), new Ork(), new Goblin(), new Goblin());
        Vlna tazkaVlna = new Vlna(3, new Goblin(), new Ork(), new Ork(), new Goblin());
        Vlna bossVlna = new Vlna(4, new Goblin(), new Goblin(), new Goblin(), new Goblin());

        this.vlny.add(lahkaVlna);
        this.vlny.add(strednaVlna);
        this.vlny.add(tazkaVlna);
        this.vlny.add(bossVlna);
        this.pocetVln = this.vlny.size();
    }

    /**
     * Vytvorí VlnaManager s vlnami načítanými zo súboru.
     * @param nacitaneVlny Zoznam vĺn načítaných zo súboru.
     */
    public VlnaManager(ArrayList<Vlna> nacitaneVlny) {
        this.cisloAktualnejVlny = 0;
        this.pocetVln = nacitaneVlny.size();
        this.vlny = nacitaneVlny;
    }

    /**
     * Zistí, či bola aktuálna vlna posledná.
     * @return true, ak je aktuálna vlna posledná, inak false.
     */
    public boolean bolaVlnaPosledna() {
        return this.pocetVln == this.cisloAktualnejVlny;
    }

    /**
     * Vráti ďalšiu vlnu v poradí.
     * @return Ďalšia vlna alebo null, ak už žiadne vlny nie sú.
     */
    public Vlna dajDalsiuVlnu() {
        if (this.vlny.isEmpty()) {
            return null;
        }
        Vlna vlnaNaVratenie = this.vlny.get(this.cisloAktualnejVlny);
        this.cisloAktualnejVlny++;
        return vlnaNaVratenie;
    }
}