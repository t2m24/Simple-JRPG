import gui.HernyRamec;
import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Ork;

public class Main {
    public static void main(String[] args) {
        Hrac hrac = new Hrac();
        Goblin g1 = new Goblin();
        Goblin g2 = new Goblin();
        Ork g3 = new Ork();
        Goblin g4 = new Goblin();
        HernyRamec hernyRamec = new HernyRamec(hrac, g1, g2, g3, g4, 1);
    }
}