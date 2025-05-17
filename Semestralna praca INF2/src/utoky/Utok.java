package utoky;

import postavy.Hrac;
import postavy.Postava;

public interface Utok {
    String getNazov();

    String getVypis(Postava utocnik, Postava ciel);

    void vykonaj(Postava utocnik, Postava ciel);
}
