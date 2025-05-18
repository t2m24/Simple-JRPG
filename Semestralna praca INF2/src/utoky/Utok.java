package utoky;

import postavy.Postava;

public interface Utok {
    String getNazov();
    String getVypis();

    void vykonaj(Postava utocnik, Postava ciel);

    default int getCenaMany() {
        return 0;
    }
}
