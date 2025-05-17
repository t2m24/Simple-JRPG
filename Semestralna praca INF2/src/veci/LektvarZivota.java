package veci;

import postavy.Hrac;

public class LektvarZivota implements VecVInventari {
    private int pocetVyliecenychHp;

    @Override
    public String getNazov() {
        return "Lektvar zivota";
    }

    @Override
    public String getVypis() {
        return "Vypil si lektvar zivota a ziskal " + this.pocetVyliecenychHp + " hp";
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVyliecenychHp = hrac.getMaxHp() - hrac.getHp();
        hrac.pridajHp(this.pocetVyliecenychHp);
    }
}
