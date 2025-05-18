package utoky;

import postavy.Postava;

/**
 * Trieda reprezentujúca základný fyzický útok "Seknutie".
 * Útok spôsobí poškodenie rovnakej výške ako sila útoku útočníka.
 */
public class Seknutie implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    /**
     * Vráti názov útoku.
     * @return Názov útoku "Seknutie"
     */
    @Override
    public String getNazov() {
        return "Seknutie";
    }

    /**
     * Vráti textový popis toho čo útok vykonal a koľko poškodenia spôsobil.
     * @return Správa popisujúca útok a spôsobené poškodenie
     */
    @Override
    public String getVypis() {
        return this.menoUtocnik + " sekol do " + this.menoCiel + ". " + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    /**
     * Vykoná útok seknutím na cieľovú postavu.
     * Poškodenie sa rovná sile útoku útočníka.
     * @param utocnik Postava vykonávajúca útok
     * @param ciel Cieľová postava, ktorá utrpí poškodenie
     */
    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        this.menoUtocnik = utocnik.getMeno();
        this.menoCiel = ciel.getMeno();
        this.poskodeniePosledneho = utocnik.getSilaUtoku();
        ciel.odoberHp(this.poskodeniePosledneho);
    }
}