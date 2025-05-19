package utoky;

import postavy.Postava;

/**
 * Rozhranie pre všetky typy útokov v hre.
 * Definuje základné operácie, ktoré musí každý útok implementovať.
 */
public interface Utok {
    /**
     * Vráti názov útoku.
     * @return Názov útoku ako reťazec
     */
    String getNazov();

    /**
     * Vráti textový popis toho čo útok vykonal a koľko poškodenia spôsobil.
     * @return Popis útoku ako reťazec
     */
    String getVypis();

    /**
     * Vykoná útok na cieľovú postavu.
     * @param utocnik Postava, ktorá útok vykonáva
     * @param ciel Postava, na ktorú sa útok zameriava
     */
    void vykonaj(Postava utocnik, Postava ciel);

    /**
     * Vráti cenu many potrebnú na vykonanie útoku.
     * @return Počet many potrebných na útok
     */
    int getCenaMany();
}