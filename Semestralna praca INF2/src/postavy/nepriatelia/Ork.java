package postavy.nepriatelia;

public class Ork extends Nepriatel {

    public Ork() {
        super("Ork", 200, 10);
    }

    public String getCestaKObrazku() {
        return "/obrazky/ork.png";
    }
}