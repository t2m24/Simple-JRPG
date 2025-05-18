package postavy;

import java.util.Random;

/**
 * Abstraktná trieda reprezentujúca postavu v hre.
 * Obsahuje základné atribúty a funkcionalitu pre životy a útok.
 */
public abstract class Postava {
    private static final Random RANDOM = new Random();
    private final String meno;
    private final int maxHp;
    private int hp;
    private final int sila;

    /**
     * Vytvorí novú postavu so zadanými parametrami.
     * @param meno Meno postavy
     * @param maxHp Maximálny počet životov
     * @param sila Základná sila útoku
     */
    public Postava(String meno, int maxHp, int sila) {
        this.meno = meno;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.sila = sila;
    }

    /**
     * @return Meno postavy
     */
    public String getMeno() {
        return this.meno;
    }

    /**
     * @return Aktuálny počet životov
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * @return true ak má postava aspoň 1 život, inak false
     */
    public boolean jeNazive() {
        return this.hp > 0;
    }

    /**
     * Vypočíta silu útoku s náhodným rozptylom ±20%.
     * @return Výsledná sila útoku
     */
    public int getSilaUtoku() {
        double rozptyl = 0.2;
        double nahodnyFaktor = 1.0 + (RANDOM.nextDouble() * 2 - 1) * rozptyl;
        return (int)Math.round(this.sila * nahodnyFaktor);
    }

    /**
     * @return Maximálny počet životov postavy
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * Zníži počet životov o zadané poškodenie.
     * @param damage Veľkosť poškodenia
     */
    public void odoberHp(int damage) {
        this.hp = this.hp - damage;
    }

    /**
     * Zvýši počet životov o zadané množstvo.
     * @param mnozstvo Veľkosť liečenia
     */
    public void pridajHp(int mnozstvo) {
        this.hp = this.hp + mnozstvo;
    }
}