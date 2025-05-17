package utoky;

import postavy.Hrac;
import postavy.Postava;
import postavy.nepriatelia.Nepriatel;

public class OhnivaGula implements MagickyUtok {

    @Override
    public String getNazov() {
        return "Ohniva gula";
    }

    @Override
    public String getVypis(Hrac utocnik, Nepriatel ciel) {
        return utocnik.getMeno() + " vrhol ohnivu gulu na " + ciel.getMeno();
    }

    @Override
    public int getCenaMany() {
        return 10;
    }

    @Override
    public void vykonaj(Hrac utocnik, Nepriatel ciel) {
        utocnik.odoberManu(this.getCenaMany());
        ciel.odoberHp((int) (utocnik.getSilaUtoku() * 1.5));
    }
}
