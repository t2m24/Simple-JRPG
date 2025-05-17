package gui;

import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Nepriatel;
import utoky.Bodnutie;
import utoky.Meteorit;
import utoky.OhnivaGula;
import utoky.Seknutie;
import utoky.Utok;
import veci.Jablko;
import veci.LektvarMany;
import veci.LektvarZivota;
import veci.VecVInventari;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class HernyRamec {
    private int aktualneCisloVlny;
    private Nepriatel[] nepriatelia;
    private Hrac hrac;
    private Utok zvolenyUtok;
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
    private JLabel manaLabel;
    private JLabel hpLabel;
    private JFrame okno;

    public HernyRamec(Hrac hrac, Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4, int cisloVlny) {
        this.hrac = new Hrac();
        this.nepriatelia = new Nepriatel[] {nepriatel1, nepriatel2, nepriatel3, nepriatel4};
        this.okno = new JFrame("Vlna " + cisloVlny);
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setContentPane(hlavnyPanel);
        this.aktualneCisloVlny = cisloVlny;

        nastavObrazokTlacidlu(nepriatelBtn1, nepriatel1);
        nastavObrazokTlacidlu(nepriatelBtn2, nepriatel2);
        nastavObrazokTlacidlu(nepriatelBtn3, nepriatel3);
        nastavObrazokTlacidlu(nepriatelBtn4, nepriatel4);

        hpProgressBar.setMaximum(hrac.getMaxHp());
        hpProgressBar.setValue(hrac.getHp());

        manaProgressBar.setMaximum(hrac.getMaxMana());
        manaProgressBar.setValue(hrac.getMana());

        this.zobrazHp();
        this.zobrazManu();
        this.nastavVypis("Toto je vlna " + this.aktualneCisloVlny);

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

        seknutie.addActionListener(e -> {
            zvolenyUtok = new Seknutie();
            nastavVypis("Zvoleny utok: " + zvolenyUtok.getNazov());
        });

        bodnutie.addActionListener(e -> {
            zvolenyUtok = new Bodnutie();
            nastavVypis("Zvoleny utok: " + zvolenyUtok.getNazov());
        });

        JPopupMenu magiaMenu = new JPopupMenu();
        JMenuItem ohnivaGula = new JMenuItem("Ohniva gula");
        JMenuItem meteorit = new JMenuItem("Meteorit");
        magiaMenu.add(ohnivaGula);
        magiaMenu.add(meteorit);

        this.magiaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magiaMenu.show(magiaBtn, 0, magiaBtn.getHeight());
            }
        });

        ohnivaGula.addActionListener(e -> {
            this.zvolenyUtok = new OhnivaGula();
            nastavVypis("Zvolena magicka schopnost: " + this.zvolenyUtok.getNazov());
        });

        meteorit.addActionListener(e -> {
            this.zvolenyUtok = new Meteorit();
            nastavVypis("Zvolená magicka schopnosť: " + this.zvolenyUtok.getNazov());
        });

        JPopupMenu inventarMenu = new JPopupMenu();
        JMenuItem jablko = new JMenuItem("Jablko");
        JMenuItem lektvarZivota = new JMenuItem("Lektvar zivota");
        JMenuItem lektvarMany = new JMenuItem("Lektvar many");
        inventarMenu.add(jablko);
        inventarMenu.add(lektvarZivota);
        inventarMenu.add(lektvarMany);

        this.inventarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventarMenu.show(inventarBtn, 0, inventarBtn.getHeight());
            }
        });

        jablko.addActionListener(e -> {
            this.pouziVecZInventara(new Jablko());
        });

        lektvarZivota.addActionListener(e -> {
            this.pouziVecZInventara(new LektvarZivota());
        });
        lektvarMany.addActionListener(e -> {
            this.pouziVecZInventara(new LektvarMany());
        });


        nepriatelBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vykonajUtokNaNepriatela(nepriatel1, nepriatelBtn1);
            }
        });

        nepriatelBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vykonajUtokNaNepriatela(nepriatel2, nepriatelBtn2);
            }
        });

        nepriatelBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vykonajUtokNaNepriatela(nepriatel3, nepriatelBtn3);
            }
        });

        nepriatelBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vykonajUtokNaNepriatela(nepriatel4, nepriatelBtn4);
            }
        });

        this.okno.pack();
        this.okno.setVisible(true);
    }

    private void nastavObrazokTlacidlu(JButton tlacidlo, Nepriatel nepriatel) {
        ImageIcon ikona = new ImageIcon(Objects.requireNonNull(HernyRamec.class.getResource(nepriatel.getCestaKObrazku())));
        Image scaled = ikona.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tlacidlo.setIcon(new ImageIcon(scaled));
        aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
    }

    private void zobrazHp() {
        this.hpLabel.setText("Hp " + this.hrac.getHp() + "/" + this.hrac.getMaxHp());
        this.hpProgressBar.setValue(this.hrac.getHp());
    }

    private void zobrazManu() {
        this.manaLabel.setText("Mana " + this.hrac.getMana() + "/" + this.hrac.getMaxMana());
        this.manaProgressBar.setValue(this.hrac.getMana());
    }

    private void nastavVypis (String vypis) {
        this.vypis.setText(vypis);
    }

    private void vykonajUtokNaNepriatela(Nepriatel nepriatel, JButton tlacidlo) {
        if (this.zvolenyUtok == null) {
            nastavVypis("Najprv si vyber útok!");
            return;
        }
        if (hrac.getMana() < this.zvolenyUtok.getCenaMany()) {
            nastavVypis("Nedostatok many!");
            return;
        }
        zvolenyUtok.vykonaj(hrac, nepriatel);
        nastavVypis(zvolenyUtok.getVypis());
        this.zobrazManu();
        this.aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
        this.skontrolujKoniecVlny();
    }

    private void aktualizujTlacidloNepriatela(Nepriatel nepriatel, JButton tlacidlo) {
        if (!nepriatel.jeNazive()) {
            tlacidlo.setVisible(false);
        } else {
            tlacidlo.setText(nepriatel.getMeno() + " " + nepriatel.getHp() + "/" + nepriatel.getMaxHp() + " HP");
            tlacidlo.setVisible(true);
        }
    }

    private void skontrolujKoniecVlny() {
        if (!this.hrac.jeNazive()) {
            this.nastavVypis("Zomrel si");
        }
        boolean vsetciMrtvi = true;
        for (Nepriatel n : this.nepriatelia) {
            if (n.jeNazive()) {
                vsetciMrtvi = false;
                break;
            }
        }
        if (vsetciMrtvi) {
            nastavVypis("Vlna dokoncena");
            Goblin g1 = new Goblin();
            Goblin g2 = new Goblin();
            Goblin g3 = new Goblin();
            Goblin g4 = new Goblin();
            HernyRamec hernyRamec = new HernyRamec(this.hrac, g1, g2, g3, g4, this.aktualneCisloVlny + 1);
        }
    }

    private void pouziVecZInventara(VecVInventari vec) {
        vec.pouzi(this.hrac);
        this.nastavVypis(vec.getVypis());
        this.zobrazManu();
        this.zobrazHp();
    }

    private void utokNepriatela (Nepriatel nepriatel, JButton tlacidlo) {
        if (!nepriatel.jeNazive()) {
            return;
        }
        zvolenyUtok.vykonaj(nepriatel, this.hrac);
        nastavVypis(zvolenyUtok.getVypis());
        this.zobrazHp();
        this.aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
        this.skontrolujKoniecVlny();
    }
}
