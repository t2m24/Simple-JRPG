package gui;

import postavy.nepriatelia.Nepriatel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HernyRamec {
    private JPanel hlavnyPanel;
    private JButton nepriatelBtn1;
    private JButton nepriatelBtn2;
    private JButton nepriatelBtn3;
    private JButton nepriatelBtn4;
    private JProgressBar hpProgressBar;
    private JProgressBar manaProgressBar;
    private JButton utokyBtn;
    private JButton magiaBtn;
    private JButton inventarBtn;
    private JLabel vypis;

    private JFrame okno;
    private Nepriatel[] nepriatelia;

    public HernyRamec(Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4, int cisloVlny, int pocetHp, int pocetMany) {
        this.nepriatelia = new Nepriatel[] {nepriatel1, nepriatel2, nepriatel3, nepriatel4};

        this.okno = new JFrame("Vlna " + cisloVlny);
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setContentPane(hlavnyPanel);

        nastavObrazok(nepriatelBtn1, nepriatelia[0]);
        nastavObrazok(nepriatelBtn2, nepriatelia[1]);
        nastavObrazok(nepriatelBtn3, nepriatelia[2]);
        nastavObrazok(nepriatelBtn4, nepriatelia[3]);

        hpProgressBar.setMaximum(100);
        hpProgressBar.setValue(pocetHp);

        manaProgressBar.setMaximum(100);
        manaProgressBar.setValue(pocetMany);

        JPopupMenu utokyMenu = new JPopupMenu();
        JMenuItem seknutie = new JMenuItem("Seknutie");
        JMenuItem bodnutie = new JMenuItem("Bodnutie");
        utokyMenu.add(seknutie);
        utokyMenu.add(bodnutie);

        this.utokyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utokyMenu.show(utokyBtn, 0, utokyBtn.getHeight());
            }
        });

        this.magiaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.inventarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        this.okno.pack();
        this.okno.setVisible(true);
    }

    private void nastavObrazok(JButton tlacidlo, Nepriatel nepriatel) {
        ImageIcon ikona = new ImageIcon(HernyRamec.class.getResource(nepriatel.getCestaKObrazku()));
        Image scaled = ikona.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tlacidlo.setIcon(new ImageIcon(scaled));
        tlacidlo.setText(nepriatel.getMeno());
    }

    public void nastavHp(int aktualneHp) {
        this.hpProgressBar.setValue(aktualneHp);
    }

    public void nastavManu(int aktualnaMana) {
        this.hpProgressBar.setValue(aktualnaMana);
    }

    public void nastavVypis (String vypis) {
        this.vypis.setText(vypis);
    }

    public void zmenVypisHpNepriatelovi(int noveHp) {

    }
}
