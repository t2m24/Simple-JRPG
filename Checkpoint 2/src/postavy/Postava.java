package postavy;

public abstract class Postava {
    private String meno;
    private int maxHp;
    private int hp;

    public Postava(String meno, int maxHp) {
        this.meno = meno;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public String getMeno() {
        return this.meno;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public void odoberHp(int damage) {
        this.hp = Math.max(0, this.hp - damage);
    }

    public abstract void utoc(Postava target);


}