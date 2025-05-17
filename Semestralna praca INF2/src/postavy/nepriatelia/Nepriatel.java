package postavy.nepriatelia;

import postavy.Postava;

public abstract class Nepriatel extends Postava {
    private String cestaKObrazku;

    public Nepriatel(String meno, int maxHp, int sila) {
        super(meno, maxHp, sila);
    }

    public String getCestaKObrazku() {
        return cestaKObrazku;
    }
}