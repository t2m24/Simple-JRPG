package utoky;

import postavy.Postava;

/**
 * Základný fyzický útok "Bodnutie".
 * Nepotrebuje manu.
 */
public class Bodnutie implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    /**
     * Vráti názov útoku.
     * @return Názov útoku "Bodnutie"
     */
    @Override
    public String getNazov() {
        return "Bodnutie";
    }

    /**
     * Vráti textový popis toho čo útok vykonal a koľko poškodenia spôsobil.
     * @return Správa opisujúca útok a spôsobené poškodenie
     */
    @Override
    public String getVypis() {
        return this.menoUtocnik + " bodol " + this.menoCiel + ". "
                + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    /**
     * Vykoná útok bodnutím.
     * Útok spôsobí poškodenie vo výške polovice sily útoku útočníka.
     * @param utocnik Postava vykonávajúca útok
     * @param ciel Cieľová postava, ktorá utrpí poškodenie
     */
    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        this.menoUtocnik = utocnik.getMeno();
        this.menoCiel = ciel.getMeno();
        this.poskodeniePosledneho = utocnik.getSilaUtoku() / 2;
        ciel.odoberHp(this.poskodeniePosledneho);
    }
}