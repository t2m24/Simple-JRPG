package gui;

import postavy.Postava;

public class UkazovatelZivotov implements Ukazovatel {
    private final Postava postava;

    public UkazovatelZivotov(Postava postava) {
        this.postava = postava;
    }

    @Override
    public String zobraz() {
        return "HP: " + this.postava.getHp() + " / " + this.postava.getMaxHp();
    }
}