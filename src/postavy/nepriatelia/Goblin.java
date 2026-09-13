package postavy.nepriatelia;

/**
 * Trieda reprezentujúca nepriateľa typu Goblin.
 * Goblin je slabší nepriateľ s 50 HP a 5 silou útoku.
 */
public class Goblin extends Nepriatel {

    /**
     * Vytvorí novú inštanciu Goblina s preddefinovanými hodnotami:
     * - Meno: "Goblin"
     * - Životy: 50
     * - Sila útoku: 5
     * - Cesta k obrázku: "/obrazky/goblin.png"
     */
    public Goblin() {
        super("Goblin", 50, 5, "/obrazky/goblin.png");
    }

    /**
     * Vráti cestu k obrázku Goblina.
     * @return Cesta k obrázkovému súboru
     */
    @Override
    public String getCestaKObrazku() {
        return "/obrazky/goblin.png";
    }
}