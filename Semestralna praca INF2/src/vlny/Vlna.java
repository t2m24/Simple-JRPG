package vlny;

import postavy.nepriatelia.Nepriatel;

public class Vlna {
    private final int cislo;
    private final Nepriatel nepriatel1;
    private final Nepriatel nepriatel2;
    private final Nepriatel nepriatel3;
    private final Nepriatel nepriatel4;

    public Vlna(int cislo, Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4) {
        this.cislo = cislo;
        this.nepriatel1 = nepriatel1;
        this.nepriatel2 = nepriatel2;
        this.nepriatel3 = nepriatel3;
        this.nepriatel4 = nepriatel4;
    }

    public Nepriatel getNepriatel1() {
        return this.nepriatel1;
    }

    public Nepriatel getNepriatel2() {
        return this.nepriatel2;
    }

    public Nepriatel getNepriatel3() {
        return this.nepriatel3;
    }

    public Nepriatel getNepriatel4() {
        return this.nepriatel4;
    }

    public String getVypis() {
        return "Vlna " + this.cislo;
    }
}
