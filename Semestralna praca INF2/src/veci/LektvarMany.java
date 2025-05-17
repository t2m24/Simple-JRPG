package veci;

import postavy.Hrac;

public class LektvarMany implements VecVInventari {
    private int pocetVratenejMany;

    @Override
    public String getNazov() {
        return "Lektvar Many";
    }

    @Override
    public String getVypis() {
        return "Vypil si lektvar many a ziskal " + this.pocetVratenejMany + " many";
    }

    @Override
    public void pouzi(Hrac hrac) {
        this.pocetVratenejMany = hrac.getMaxMana() - hrac.getMana();
        hrac.pridajManu(this.pocetVratenejMany);
    }
}
