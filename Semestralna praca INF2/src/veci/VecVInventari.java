package veci;

import postavy.Hrac;

/**
 * Rozhranie pre veci, ktoré môže hráč použiť.
 * Definuje základné operácie, ktoré s takouto vecou môže hráč vykonať.
 */
public interface VecVInventari {
    /**
     * Vráti názov predmetu.
     * @return Názov veci ako reťazec.
     */
    String getNazov();

    /**
     * Vráti textovú reprezentáciu účinku veci pri použití.
     * @return Reťazec s popisom účinku veci.
     */
    String getVypis();

    /**
     * Použije danú vec na hráča. Implementácia tejto metódy definuje špecifický účinok veci.
     * @param hrac Hráč, ktorý vec používa.
     */
    void pouzi(Hrac hrac);
}