package utoky;

import postavy.Postava;

public class Bodnutie implements Utok{
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    @Override
    public String getNazov() {
        return "Bodnutie";
    }

    @Override
    public String getVypis() {
        return this.menoUtocnik + " bodol " + this.menoCiel + ". " + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        this.menoUtocnik = utocnik.getMeno();
        this.menoCiel = ciel.getMeno();
        this.poskodeniePosledneho = utocnik.getSilaUtoku() / 2;

        ciel.odoberHp(this.poskodeniePosledneho);
    }
}
