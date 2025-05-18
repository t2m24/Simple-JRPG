package postavy;

/**
 * Trieda reprezentujúca hráča v hre.
 * Rozširuje základnú funkcionalitu postavy o manu.
 */
public class Hrac extends Postava {
    private final int maxMana;
    private int mana;

    /**
     * Vytvorí novú inštanciu hráča so základnými hodnotami:
     * - 100 max HP
     * - 40 základnej sily útoku
     * - 100 max many
     */
    public Hrac() {
        super("Hrac", 100, 40);
        this.maxMana = 100;
        this.mana = this.maxMana;
    }

    /**
     * @return Aktuálne množstvo many
     */
    public int getMana() {
        return this.mana;
    }

    /**
     * @return Maximálne množstvo many
     */
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * Zníži množstvo many o zadanú hodnotu.
     * @param mnozstvo Množstvo many k odobratiu
     */
    public void odoberManu(int mnozstvo) {
        this.mana = this.mana - mnozstvo;
    }

    /**
     * Zvýši množstvo many o zadanú hodnotu.
     * @param mnozstvo Množstvo many k pridaniu
     */
    public void pridajManu(int mnozstvo) {
        this.mana = this.mana + mnozstvo;
    }
}