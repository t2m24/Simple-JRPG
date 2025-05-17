package postavy.nepriatelia;

import postavy.Postava;

public class Goblin extends Nepriatel {
    public Goblin(String meno, int maxHp) {
        super(meno, maxHp);
    }

    @Override
    public void utoc(Postava ciel) {
        ciel.odoberHp(5);
    }
}