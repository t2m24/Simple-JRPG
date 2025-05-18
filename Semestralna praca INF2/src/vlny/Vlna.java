package vlny;

import postavy.nepriatelia.Nepriatel;

/**
 * Reprezentuje jednu vlnu nepriateľov v hre.
 */
public class Vlna {
    private final int cislo;
    private final Nepriatel nepriatel1;
    private final Nepriatel nepriatel2;
    private final Nepriatel nepriatel3;
    private final Nepriatel nepriatel4;

    /**
     * Vytvorí novú vlnu s daným číslom a nepriateľmi.
     * @param cislo Číslo vlny.
     * @param nepriatel1 Prvý nepriateľ vo vlne.
     * @param nepriatel2 Druhý nepriateľ vo vlne.
     * @param nepriatel3 Tretí nepriateľ vo vlne.
     * @param nepriatel4 Štvrtý nepriateľ vo vlne.
     */
    public Vlna(int cislo, Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4) {
        this.cislo = cislo;
        this.nepriatel1 = nepriatel1;
        this.nepriatel2 = nepriatel2;
        this.nepriatel3 = nepriatel3;
        this.nepriatel4 = nepriatel4;
    }

    /**
     * Vráti prvého nepriateľa vo vlne.
     * @return Prvý nepriateľ.
     */
    public Nepriatel getNepriatel1() {
        return this.nepriatel1;
    }

    /**
     * Vráti druhého nepriateľa vo vlne.
     * @return Druhý nepriateľ.
     */
    public Nepriatel getNepriatel2() {
        return this.nepriatel2;
    }

    /**
     * Vráti tretieho nepriateľa vo vlne.
     * @return Tretí nepriateľ.
     */
    public Nepriatel getNepriatel3() {
        return this.nepriatel3;
    }

    /**
     * Vráti štvrtého nepriateľa vo vlne.
     * @return Štvrtý nepriateľ.
     */
    public Nepriatel getNepriatel4() {
        return this.nepriatel4;
    }

    /**
     * Vráti výpis s číslom vlny.
     * @return String s číslom vlny.
     */
    public String getVypis() {
        return "Vlna " + this.cislo;
    }
}