public class UkazovatelMany implements Ukazovatel {
    private Postava postava;

    public UkazovatelMany(Postava postava) {
        this.postava = postava;
    }

    @Override
    public String getDisplay() {
        return "Mana: " + postava.getMana() + " / " + postava.getMaxMana();
    }
}