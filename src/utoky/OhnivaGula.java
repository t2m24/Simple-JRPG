package utoky;

import postavy.Hrac;
import postavy.Postava;

/**
 * Magický útok "Ohnivá guľa", ktorý spôsobuje zvýšené poškodenie
 * Spotrebuje 10 many, spôsobí 1.5x poškodenie, môže vykonať iba hráč.
 */
public class OhnivaGula implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    /**
     * Vráti názov útoku.
     * @return Názov útoku "Ohnivá guľa"
     */
    @Override
    public String getNazov() {
        return "Ohniva gula";
    }

    /**
     * Vráti textový popis toho čo útok vykonal a koľko poškodenia spôsobil.
     * @return Správa opisujúca útok a spôsobené poškodenie
     */
    @Override
    public String getVypis() {
        return this.menoUtocnik + " vrhol ohnivu gulu na " + this.menoCiel + ". "
                + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    /**
     * Vykoná magický útok ohnivou guľou.
     * Útok spôsobí poškodenie vo výške 1.5x sila útoku útočníka
     * a spotrebuje 10 many. Útok môže vykonať iba hráč.
     * @param utocnik Hráč vykonávajúci útok
     * @param ciel Cieľová postava, ktorá utrpí poškodenie
     * @throws ClassCastException ak útočník nie je hráč
     */
    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        if (utocnik instanceof Hrac) {
            this.menoUtocnik = utocnik.getMeno();
            this.menoCiel = ciel.getMeno();
            ((Hrac)utocnik).odoberManu(this.getCenaMany());
            this.poskodeniePosledneho = (int)(utocnik.getSilaUtoku() * 1.5);
            ciel.odoberHp(this.poskodeniePosledneho);
        }
    }

    /**
     * Vráti cenu many potrebnú na vykonanie útoku.
     * @return Množstvo many potrebné na útok (10)
     */
    @Override
    public int getCenaMany() {
        return 10;
    }
}