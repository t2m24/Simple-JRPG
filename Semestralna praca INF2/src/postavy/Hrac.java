package postavy;

public class Hrac extends Postava {
    private final int maxMana;
    private int mana;

    public Hrac() {
        super("Hrac", 100, 40);
        this.maxMana = 100;
        this.mana = this.maxMana;
    }

    public int getMana() {
        return this.mana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public void odoberManu(int mnozstvo) {
        this.mana = this.mana - mnozstvo;
    }

    public void pridajManu(int mnozstvo) {
        this.mana = this.mana + mnozstvo;
    }
}