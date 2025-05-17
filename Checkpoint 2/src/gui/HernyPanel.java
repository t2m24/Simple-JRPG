package gui;

import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Nepriatel;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class HernyPanel extends JPanel {
    private HernyRamec hernyRamec;
    private Hrac hrac;
    private Nepriatel nepriatel;

    private Ukazovatel ukazovatelZivotov;
    private Ukazovatel ukazovatelMany;
    private Ukazovatel ukazovatelZivotovNepriatela;

    public HernyPanel(HernyRamec hernyRamec) {
        this.hernyRamec = hernyRamec;

        this.hrac = new Hrac("Hrdina", 100, 50);
        this.nepriatel = new Goblin("Goblin", 50);

        this.ukazovatelZivotov = new UkazovatelZivotov(this.hrac);
        this.ukazovatelMany = new UkazovatelMany(this.hrac);
        this.ukazovatelZivotovNepriatela = new UkazovatelZivotov(this.nepriatel);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.drawString("Hráč: " + this.hrac.getMeno(), 20, 20);
        g.drawString(this.ukazovatelZivotov.zobraz(), 20, 40);
        g.drawString(this.ukazovatelMany.zobraz(), 20, 60);

        g.drawString("Nepriateľ: " + this.nepriatel.getMeno(), 300, 20);
        g.drawString(this.ukazovatelZivotovNepriatela.zobraz(), 300, 40);
    }

    public void utoc() {
        this.hrac.utoc(this.nepriatel);
        this.hernyRamec.aktualizujStav("Hráč zaútočil na nepriateľa!");
        repaint();
    }

    public void pouzitMagiu() {
        if (this.hrac.getMana() >= 10) {
            this.hrac.pouziMagiu(this.nepriatel);
            this.hernyRamec.aktualizujStav("Hráč použil magiu!");
        } else {
            this.hernyRamec.aktualizujStav("Nie je dostatok many na kúzlo!");
        }
        repaint();
    }
}