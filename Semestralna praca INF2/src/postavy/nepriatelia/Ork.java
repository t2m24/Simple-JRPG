package postavy.nepriatelia;

public class Ork extends Nepriatel {

    public Ork() {
        super("Ork", 100, 10, "/obrazky/ork.png");
    }

    public String getCestaKObrazku() {
        return "/obrazky/ork.png";
    }
}