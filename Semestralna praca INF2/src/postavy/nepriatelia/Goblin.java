package postavy.nepriatelia;

public class Goblin extends Nepriatel {

    public Goblin() {
        super("Goblin", 100, 5);
    }

    public String getCestaKObrazku() {
        return "/obrazky/goblin.png";
    }
}