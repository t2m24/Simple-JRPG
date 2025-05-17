import gui.HernyRamec;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Ork;

public class Main {
    public static void main(String[] args) {
        Goblin g1 = new Goblin();
        Goblin g2 = new Goblin();
        Ork g3 = new Ork();
        Goblin g4 = new Goblin();
        HernyRamec hernyRamec = new HernyRamec(g1, g2, g3, g4, 1, 100, 100);
    }
}