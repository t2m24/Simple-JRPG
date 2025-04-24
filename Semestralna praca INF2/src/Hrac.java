public class Hrac extends Postava {
    public Hrac(String meno, int maxHp, int maxMana) {
        super(meno, maxHp, maxMana);
    }

    @Override
    public void utok(Postava target) {
        // Simple physical attack dealing 10 damage
        target.takeDamage(10);
    }
}