package postavy;

public class Hrac extends Postava {
    private int maxMana;
    private int mana;

    public Hrac() {
        super("Hrac", 100, 40);
        this.maxMana = 100;
        this.mana = maxMana;
    }

    public int getMana() {
        return this.mana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public void pouziMagiu(Postava ciel) {
        if (this.mana >= 10) {
            this.odoberManu(10);
            ciel.odoberHp(15);
        }
    }

    public void odoberManu(int mnozstvo) {
        this.mana = this.mana - mnozstvo;
    }

    public void pridajManu(int mnozstvo) {
        this.mana = this.mana + mnozstvo;
    }
}