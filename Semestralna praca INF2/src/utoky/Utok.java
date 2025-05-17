package utoky;

import postavy.Hrac;
import postavy.Postava;
import postavy.nepriatelia.Nepriatel;

public interface Utok {
    String getNazov();
    String getVypis();

    void vykonaj(Postava utocnik, Postava ciel);

    default boolean jeMagicky() {
        return false;
    }

    default int getCenaMany() {
        return 0;
    }
}
