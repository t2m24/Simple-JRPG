package postavy.nepriatelia;

/**
 * Trieda reprezentujúca nepriateľa typu Ork.
 * Ork je silný nepriateľ so 100 HP a 10 silou útoku.
 */
public class Ork extends Nepriatel {

    /**
     * Vytvorí novú inštanciu Orka s preddefinovanými hodnotami:
     * - Meno: "Ork"
     * - Životy: 100
     * - Sila útoku: 10
     * - Cesta k obrázku: "/obrazky/ork.png"
     */
    public Ork() {
        super("Ork", 100, 10, "/obrazky/ork.png");
    }

    /**
     * Vráti cestu k obrázku Orka.
     * @return Cesta k obrázkovému súboru
     */
    @Override
    public String getCestaKObrazku() {
        return "/obrazky/ork.png";
    }
}