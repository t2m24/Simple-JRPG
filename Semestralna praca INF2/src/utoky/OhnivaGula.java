package utoky;

import postavy.Hrac;
import postavy.Postava;

public class OhnivaGula implements Utok {
    private String menoUtocnik;
    private String menoCiel;
    private int poskodeniePosledneho;

    @Override
    public String getNazov() {
        return "Ohniva gula";
    }

    @Override
    public String getVypis() {
        return this.menoUtocnik + " vrhol ohnivu gulu na " + this.menoCiel + ". " + this.menoCiel + " utrpel zranenie " + this.poskodeniePosledneho;
    }

    @Override
    public void vykonaj(Postava utocnik, Postava ciel) {
        if (utocnik instanceof Hrac) {
            this.menoUtocnik = utocnik.getMeno();
            this.menoCiel = ciel.getMeno();
            ((Hrac)utocnik).odoberManu(this.getCenaMany());
            this.poskodeniePosledneho = (int)(utocnik.getSilaUtoku() * 1.5);
            ciel.odoberHp(this.poskodeniePosledneho);
        }
    }

    @Override
    public int getCenaMany() {
        return 10;
    }
}
