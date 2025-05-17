package utoky;

import postavy.Postava;

public class Seknutie implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    @Override
    public String getNazov() {
        return "Seknutie";
    }

    @Override
    public String getVypis() {
        return this.menoUtocnik + " sekol do " + this.menoCiel + ". " + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        this.menoUtocnik = utocnik.getMeno();
        this.menoCiel = ciel.getMeno();
        this.poskodeniePosledneho = utocnik.getSilaUtoku();
        ciel.odoberHp(this.poskodeniePosledneho);
    }
}
