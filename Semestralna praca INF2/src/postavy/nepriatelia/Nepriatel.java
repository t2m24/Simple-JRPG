package postavy.nepriatelia;

import postavy.Postava;

/**
 * Abstraktná trieda reprezentujúca základného nepriateľa v hre.
 * Rozširuje základnú postavu o funkcionalitu pre prácu s obrázkami.
 */
public abstract class Nepriatel extends Postava {
    private final String cestaKObrazku;

    /**
     * Vytvorí nového nepriateľa so zadanými parametrami.
     * @param meno Meno nepriateľa
     * @param maxHp Maximálny počet životov
     * @param sila Základná sila útoku
     * @param cestaKObrazku Cesta k obrázku nepriateľa
     */
    public Nepriatel(String meno, int maxHp, int sila, String cestaKObrazku) {
        super(meno, maxHp, sila);
        this.cestaKObrazku = cestaKObrazku;
    }

    /**
     * Vráti cestu k obrázku nepriateľa.
     * @return Cesta k obrázkovému súboru
     */
    public String getCestaKObrazku() {
        return this.cestaKObrazku;
    }
}