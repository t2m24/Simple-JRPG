package veci;

import postavy.Hrac;

public class Jablko implements VecVInventari {
    private int pocetVyliecenychHp;

    @Override
    public String getNazov() {
        return "Jablko";
    }

    @Override
    public String getVypis() {
        return "Zjedol si jablko a ziskal " + this.pocetVyliecenychHp + " hp";
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVyliecenychHp = (int) (hrac.getMaxHp() * 0.50);
        if (this.pocetVyliecenychHp +  hrac.getHp() > hrac.getMaxHp()) {
            this.pocetVyliecenychHp = hrac.getMaxHp() - hrac.getHp();
            hrac.pridajHp(this.pocetVyliecenychHp);
            return;
        }
        hrac.pridajHp(this.pocetVyliecenychHp);
    }
}
