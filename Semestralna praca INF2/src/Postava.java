public abstract class Postava {
    private String meno;
    private int maxHp;
    private int hp;
    private int maxMana;
    private int mana;

    public Postava(String meno, int maxHp, int maxMana) {
        this.meno = meno;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.maxMana = maxMana;
        this.mana = maxMana;
    }

    public String getMeno() {
        return meno;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void takeDamage(int damage) {
        hp = Math.max(0, hp - damage);
    }

    public void useMana(int amount) {
        mana = Math.max(0, mana - amount);
    }

    // Each character must implement its own attack behavior
    public abstract void utok(Postava target);

    // A generic magic attack method (costs 10 mana, deals 15 damage)
    public void castMagic(Postava target) {
        if (mana >= 10) {
            useMana(10);
            target.takeDamage(15);
        }
    }
}