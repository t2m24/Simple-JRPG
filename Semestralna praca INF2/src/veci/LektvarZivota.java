package veci;

import postavy.Hrac;

/**
 * Reprezentuje lektvar, ktorý vylieči životy hráča.
 * Po použití obnoví všetky chýbajúce hp hráča.
 */
public class LektvarZivota implements VecVInventari {
    private int pocetVyliecenychHp;

    /**
     * Vráti názov predmetu.
     * @return Názov lektvaru.
     */
    @Override
    public String getNazov() {
        return "Lektvar zivota";
    }

    /**
     * Vráti textovú reprezentáciu účinku lektvaru.
     * @return Textová reprezentácia účinku.
     */
    @Override
    public String getVypis() {
        return "Vypil si lektvar zivota a ziskal " + this.pocetVyliecenychHp + " hp";
    }

    /**
     * Použije lektvar na hráča, čím mu doplní hp na maximum.
     * @param hrac Hráč, ktorý lektvar používa.
     */
    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVyliecenychHp = hrac.getMaxHp() - hrac.getHp();
        hrac.pridajHp(this.pocetVyliecenychHp);
    }
}