package postavy.nepriatelia;

public class Goblin extends Nepriatel {

    public Goblin() {
        super("Goblin", 50, 5);
    }

    public String getCestaKObrazku() {
        return "/obrazky/goblin.png";
    }
}