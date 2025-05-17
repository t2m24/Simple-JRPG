package utoky;

import postavy.Postava;

public class Seknutie implements Utok{

    @Override
    public String getNazov() {
        return "Seknutie";
    }

    @Override
    public String getVypis(Postava utocnik, Postava ciel) {
        return utocnik.getMeno() + " zautocil na " + ciel.getMeno() + " utokom " + this.getNazov();
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        ciel.odoberHp(utocnik.getSilaUtoku());
    }
}
