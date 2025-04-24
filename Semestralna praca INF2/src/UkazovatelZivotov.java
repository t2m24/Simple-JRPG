public class UkazovatelZivotov implements Ukazovatel {
    private Postava postava;

    public UkazovatelZivotov(Postava postava) {
        this.postava = postava;
    }

    @Override
    public String getDisplay() {
        return "HP: " + postava.getHp() + " / " + postava.getMaxHp();
    }
}