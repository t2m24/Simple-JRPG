package veci;

import postavy.Hrac;

/**
 * Predstavuje jablko, ktoré obnoví 50% maximálnych HP hráča.
 * Množstvo vyliečených HP nepresiahne maximálne HP hráča.
 */
public class Jablko implements VecVInventari {
    private int pocetVyliecenychHp;

    /**
     * Vráti názov predmetu.
     * @return Názov "Jablko"
     */
    @Override
    public String getNazov() {
        return "Jablko";
    }

    /**
     * Vráti textovú reprezentáciu účinku jablka.
     * @return Text obsahujúci množstvo obnovených HP
     */
    @Override
    public String getVypis() {
        return "Zjedol si jablko a ziskal " + this.pocetVyliecenychHp + " hp";
    }

    /**
     * Použije jablko na obnovenie HP hráča.
     * Obnoví 50% maximálnych HP, ale nepresiahne maximum.
     * @param hrac Hráč, ktorý použije jablko
     */
    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVyliecenychHp = (int)(hrac.getMaxHp() * 0.50);
        if (this.pocetVyliecenychHp + hrac.getHp() > hrac.getMaxHp()) {
            this.pocetVyliecenychHp = hrac.getMaxHp() - hrac.getHp();
            hrac.pridajHp(this.pocetVyliecenychHp);
            return;
        }
        hrac.pridajHp(this.pocetVyliecenychHp);
    }
}