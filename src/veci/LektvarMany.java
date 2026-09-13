package veci;

import postavy.Hrac;

/**
 * Reprezentuje lektvar, ktorý dopĺňa manu hráča na maximálnu hodnotu.
 * Po použití obnoví všetku chýbajúcu manu hráča.
 */
public class LektvarMany implements VecVInventari {
    private int pocetVratenejMany;

    /**
     * Vráti názov predmetu.
     * @return Názov lektvaru.
     */
    @Override
    public String getNazov() {
        return "Lektvar Many";
    }

    /**
     *  Vráti textovú reprezentáciu účinku lektvaru.
     *  @return Textová reprezentácia účinku.
     */
    @Override
    public String getVypis() {
        return "Vypil si lektvar many a ziskal " + this.pocetVratenejMany + " many";
    }

    /**
     * Použije lektvar na hráča, čím mu doplní manu na maximum.
     * @param hrac Hráč, ktorý použije lektvar.
     */
    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVratenejMany = hrac.getMaxMana() - hrac.getMana();
        hrac.pridajManu(this.pocetVratenejMany);
    }
}