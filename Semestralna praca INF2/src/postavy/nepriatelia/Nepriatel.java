package postavy.nepriatelia;

import postavy.Postava;

public abstract class Nepriatel extends Postava {
    private final String cestaKObrazku;

    public Nepriatel(String meno, int maxHp, int sila, String cestaKObrazku) {
        super(meno, maxHp, sila);
        this.cestaKObrazku = cestaKObrazku;
    }

    public String getCestaKObrazku() {
        return this.cestaKObrazku;
    }
}