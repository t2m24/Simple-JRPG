package vlny;

import postavy.nepriatelia.Nepriatel;

public class Vlna {
    private int cislo;
    private Nepriatel nepriatel1;
    private Nepriatel nepriatel2;
    private Nepriatel nepriatel3;
    private Nepriatel nepriatel4;

    public Vlna(int cislo, Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4) {
        this.cislo = cislo;
        this.nepriatel1 = nepriatel1;
        this.nepriatel2 = nepriatel2;
        this.nepriatel3 = nepriatel3;
        this.nepriatel4 = nepriatel4;
    }

    public int getCislo() {
        return cislo;
    }

    public Nepriatel getNepriatel1() {
        return nepriatel1;
    }

    public Nepriatel getNepriatel2() {
        return nepriatel2;
    }

    public Nepriatel getNepriatel3() {
        return nepriatel3;
    }

    public Nepriatel getNepriatel4() {
        return nepriatel4;
    }

    public String getVypis() {
        return "Vlna " + this.cislo;
    }
}
