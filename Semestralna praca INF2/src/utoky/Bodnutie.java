package utoky;

import postavy.Postava;

public class Bodnutie implements Utok{
    @Override
    public String getNazov() {
        return "Bodnutie";
    }

    @Override
    public String getVypis(Postava utocnik, Postava ciel) {
        return utocnik.getMeno() + " bodol " + ciel.getMeno();
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        ciel.odoberHp((int) utocnik.getSilaUtoku() / 2);
    }
}
