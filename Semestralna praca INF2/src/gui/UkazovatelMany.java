package gui;

import postavy.Hrac;

public class UkazovatelMany implements Ukazovatel {
    private Hrac hrac;

    public UkazovatelMany(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String zobraz() {
        return "Mana: " + this.hrac.getMana() + " / " + this.hrac.getMaxMana();
    }
}