package utoky;

import postavy.Hrac;
import postavy.Postava;

public class Meteorit implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    @Override
    public String getNazov() {
        return "Meteorit";
    }

    @Override
    public String getVypis() {
        return this.menoUtocnik + " vrhol meteorit na " + this.menoCiel + ". " + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        if (utocnik instanceof Hrac) {
            this.menoUtocnik = utocnik.getMeno();
            this.menoCiel = ciel.getMeno();
            ((Hrac) utocnik).odoberManu(this.getCenaMany());
            this.poskodeniePosledneho = (int) (utocnik.getSilaUtoku() * 2.5);
            ciel.odoberHp(poskodeniePosledneho);
        }
    }

    @Override
    public boolean jeMagicky() {
        return true;
    }

    @Override
    public int getCenaMany() {
        return 30;
    }
}
