package utoky;

import postavy.Hrac;
import postavy.Postava;
import postavy.nepriatelia.Nepriatel;

public interface MagickyUtok {
    String getNazov();

    String getVypis(Hrac utocnik, Nepriatel ciel);

    int getCenaMany();

    void vykonaj(Hrac utocnik, Nepriatel ciel);
}
