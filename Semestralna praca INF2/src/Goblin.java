public class Goblin extends Nepriatel {
    public Goblin(String meno, int maxHp, int maxMana) {
        super(meno, maxHp, maxMana);
    }

    @Override
    public void utok(Postava target) {
        // Goblin's attack deals 5 damage
        target.takeDamage(5);
    }
}