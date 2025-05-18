package postavy;

import java.util.Random;

public abstract class Postava {
    private static final Random random = new Random();
    private String meno;
    private int maxHp;
    private int hp;
    private int sila;

    public Postava(String meno, int maxHp, int sila) {
        this.meno = meno;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.sila = sila;
    }

    public String getMeno() {
        return this.meno;
    }

    public int getHp() {
        return this.hp;
    }

    public boolean jeNazive() {
        return this.hp > 0;
    }

    public int getSilaUtoku() {
        double rozptyl = 0.2;
        double nahodnyFaktor = 1.0 + (random.nextDouble() * 2 - 1) * rozptyl;
        return (int) Math.round(this.sila * nahodnyFaktor);
    }


    public int getMaxHp() {
        return this.maxHp;
    }

    public void odoberHp(int damage) {
        this.hp = this.hp - damage;
    }

    public void pridajHp(int mnozstvo) {
        this.hp = this.hp + mnozstvo;
    }
}