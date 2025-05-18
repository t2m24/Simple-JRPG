package postavy.nepriatelia;

public class Goblin extends Nepriatel {

    public Goblin() {
        super("Goblin", 50, 5,  "/obrazky/goblin.png");
    }

    public String getCestaKObrazku() {
        return "/obrazky/goblin.png";
    }
}