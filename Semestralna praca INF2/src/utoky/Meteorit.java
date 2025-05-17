package utoky;

import postavy.Hrac;
import postavy.nepriatelia.Nepriatel;

public class Meteorit implements MagickyUtok {

    @Override
    public String getNazov() {
        return "Meteorit";
    }

    @Override
    public String getVypis(Hrac utocnik, Nepriatel ciel) {
        return utocnik.getMeno() + " vrhol meteorit na " + ciel.getMeno();
    }

    @Override
    public int getCenaMany() {
        return 30;
    }

    @Override
    public void vykonaj(Hrac utocnik, Nepriatel ciel) {
        utocnik.odoberManu(this.getCenaMany());
        ciel.odoberHp((int) (utocnik.getSilaUtoku() * 2.5));
    }
}
