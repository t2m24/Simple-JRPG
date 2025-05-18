package gui;

import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Nepriatel;
import postavy.nepriatelia.Ork;
import utoky.Bodnutie;
import utoky.Meteorit;
import utoky.OhnivaGula;
import utoky.Seknutie;
import utoky.Utok;
import veci.Jablko;
import veci.LektvarMany;
import veci.LektvarZivota;
import veci.VecVInventari;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class HernyRamec {
    private int aktualneCisloVlny;
    private HashMap<JButton, Nepriatel> nepriatelia;
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
    private JTextArea konzola;
    private JFrame konzolaOkno;


    public HernyRamec(Hrac hrac, Nepriatel nepriatel1, Nepriatel nepriatel2, Nepriatel nepriatel3, Nepriatel nepriatel4, int cisloVlny) {
        this.hrac = hrac;
        this.nepriatelia = new HashMap<>();
        this.aktualneCisloVlny = cisloVlny;

        this.okno = new JFrame("Vlna " + cisloVlny);
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setContentPane(hlavnyPanel);

        nastavObrazokTlacidlu(nepriatelBtn1, nepriatel1);
        nastavObrazokTlacidlu(nepriatelBtn2, nepriatel2);
        nastavObrazokTlacidlu(nepriatelBtn3, nepriatel3);
        nastavObrazokTlacidlu(nepriatelBtn4, nepriatel4);

        //nieje moj kod
        konzola = new JTextArea(20, 40);
        konzola.setEditable(false);
        konzola.setLineWrap(true);
        konzola.setWrapStyleWord(true);

        konzolaOkno = new JFrame("Konzola");
        konzolaOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        konzolaOkno.add(new JScrollPane(konzola));

        this.nepriatelia.put(nepriatelBtn1, nepriatel1);
        this.nepriatelia.put(nepriatelBtn2, nepriatel2);
        this.nepriatelia.put(nepriatelBtn3, nepriatel3);
        this.nepriatelia.put(nepriatelBtn4, nepriatel4);

        hpProgressBar.setMaximum(hrac.getMaxHp());
        hpProgressBar.setValue(hrac.getHp());

        manaProgressBar.setMaximum(hrac.getMaxMana());
        manaProgressBar.setValue(hrac.getMana());

        this.zobrazHp();
        this.zobrazManu();
        this.nastavVypis("Toto je vlna " + this.aktualneCisloVlny);

        JPopupMenu utokyMenu = new JPopupMenu();
        JMenuItem seknutie = new JMenuItem("Seknutie - Zakladny utok");
        JMenuItem bodnutie = new JMenuItem("Bodnutie - Menej poskodenia ako seknutie, sposobi krvacanie");
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
        JMenuItem ohnivaGula = new JMenuItem("Ohniva gula - Sposobi poskodenie, 10 mana");
        JMenuItem meteorit = new JMenuItem("Meteorit - Sposobi velke poskoenie, 30 mana");
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
        JMenuItem jablko = new JMenuItem("Jablko - Vylieci 50% hp");
        JMenuItem lektvarZivota = new JMenuItem("Lektvar zivota - Doplni hp");
        JMenuItem lektvarMany = new JMenuItem("Lektvar many - Doplni manu");
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
            this.nepriateliaUtok();
        });

        lektvarZivota.addActionListener(e -> {
            this.pouziVecZInventara(new LektvarZivota());
            this.nepriateliaUtok();
        });
        lektvarMany.addActionListener(e -> {
            this.pouziVecZInventara(new LektvarMany());
            this.nepriateliaUtok();
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

        //nieje moj kod
        Font nepriatelFont = new Font("Arial", Font.BOLD, 16);
        nepriatelBtn1.setFont(nepriatelFont);
        nepriatelBtn2.setFont(nepriatelFont);
        nepriatelBtn3.setFont(nepriatelFont);
        nepriatelBtn4.setFont(nepriatelFont);

        Font tlacidlaFont = new Font("Arial", Font.BOLD, 18);
        utokyBtn.setFont(tlacidlaFont);
        magiaBtn.setFont(tlacidlaFont);
        inventarBtn.setFont(tlacidlaFont);

        Font stavFont = new Font("Arial", Font.BOLD, 16);
        hpLabel.setFont(stavFont);
        manaLabel.setFont(stavFont);

        Font vypisFont = new Font("Arial", Font.ITALIC, 16);
        vypis.setFont(vypisFont);

        vypis.setForeground(Color.BLUE);
        hpLabel.setForeground(new Color(200, 0, 0));
        manaLabel.setForeground(new Color(0, 0, 200));

        okno.setSize(1280,720);
        okno.setLocationRelativeTo(null);
        this.okno.setVisible(true);

        konzolaOkno.pack();
        konzolaOkno.setVisible(true);

        //nieje moj kod
        Point hlavneOknoPozicia = this.okno.getLocation();
        int hlavneOknoSirka = this.okno.getWidth();
        konzolaOkno.setLocation(hlavneOknoPozicia.x + hlavneOknoSirka, hlavneOknoPozicia.y);
    }

    //nieje moj kod
    private void nastavObrazokTlacidlu(JButton tlacidlo, Nepriatel nepriatel) {
        ImageIcon ikona = new ImageIcon(Objects.requireNonNull(HernyRamec.class.getResource(nepriatel.getCestaKObrazku())));
        Image scaled = ikona.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tlacidlo.setIcon(new ImageIcon(scaled));
        aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
    }


    private void zobrazHp() {
        if (this.hrac.getHp() < 0) {
            this.hpLabel.setText("Hp " + 0 + "/" + this.hrac.getMaxHp());
        } else {
            this.hpLabel.setText("Hp " + this.hrac.getHp() + "/" + this.hrac.getMaxHp());
        }
        this.hpProgressBar.setValue(this.hrac.getHp());
    }


    private void zobrazManu() {
        this.manaLabel.setText("Mana " + this.hrac.getMana() + "/" + this.hrac.getMaxMana());
        this.manaProgressBar.setValue(this.hrac.getMana());
    }


    private void nastavVypis (String vypis) {
        this.vypis.setText(vypis);
    }

    //nieje moj kod
    public void vypisDoKonzoly(String sprava) {
        konzola.append(sprava + "\n");
        konzola.setCaretPosition(konzola.getDocument().getLength());
    }


    private void vykonajUtokNaNepriatela(Nepriatel nepriatel, JButton tlacidlo) {
        if (!hrac.jeNazive()) {
            return;
        }
        if (this.zvolenyUtok == null) {
            nastavVypis("Najprv si vyber útok!");
            return;
        }
        if (hrac.getMana() < this.zvolenyUtok.getCenaMany()) {
            nastavVypis("Nedostatok many!");
            return;
        }
        zvolenyUtok.vykonaj(hrac, nepriatel);
        this.vypisDoKonzoly(zvolenyUtok.getVypis());
        this.zvolenyUtok = null;
        this.zobrazManu();
        this.aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
        this.nepriateliaUtok();
        this.skontrolujKoniecVlny();
    }


    private void nepriatelUtokNaHraca(Nepriatel nepriatel, Hrac hrac) {
        Seknutie nepriatelskyUtok = new Seknutie();
        nepriatelskyUtok.vykonaj(nepriatel, hrac);
        this.vypisDoKonzoly(nepriatelskyUtok.getVypis());
        this.zobrazHp();
        if (!hrac.jeNazive()) {
            return;
        }
        this.skontrolujKoniecVlny();
    }


    private void aktualizujTlacidloNepriatela(Nepriatel nepriatel, JButton tlacidlo) {
        if (!nepriatel.jeNazive()) {
            this.nepriatelia.remove(tlacidlo);
            tlacidlo.setVisible(false);
        } else {
            tlacidlo.setText(nepriatel.getMeno() + " " + nepriatel.getHp() + "/" + nepriatel.getMaxHp() + " HP");
            tlacidlo.setVisible(true);
        }
    }


    private void skontrolujKoniecVlny() {
        if (!this.hrac.jeNazive()) {
            new ZomrelSiObrazovka(this.okno, this.konzolaOkno);
            this.zablokujTlacidla();
            return;
        }
        boolean vsetciMrtvi = true;
        for (Nepriatel n : this.nepriatelia.values()) {
            if (n.jeNazive()) {
                vsetciMrtvi = false;
                break;
            }
        }
        if (vsetciMrtvi) {
            this.vypisDoKonzoly("Vlna dokoncena");
            this.okno.setVisible(false);
            this.okno.dispose();
            this.konzolaOkno.setVisible(false);
            this.konzolaOkno.dispose();
            Goblin g1 = new Goblin();
            Ork g2 = new Ork();
            Ork g3 = new Ork();
            Goblin g4 = new Goblin();
            new HernyRamec(this.hrac ,g1, g2, g3, g4, this.aktualneCisloVlny + 1);
        }
    }


    private void pouziVecZInventara(VecVInventari vec) {
        vec.pouzi(this.hrac);
        this.vypisDoKonzoly(vec.getVypis());
        this.zobrazManu();
        this.zobrazHp();
    }


    private void nepriateliaUtok() {
        int hpPred = this.hrac.getHp();
        for (JButton b : this.nepriatelia.keySet()) {
            Nepriatel n = this.nepriatelia.get(b);
            if (n.jeNazive()) {
                this.nepriatelUtokNaHraca(n, this.hrac);
            }
        }
        this.vypisDoKonzoly("");
        this.nastavVypis("Nepriatelia zautocili, startil si " + (hpPred - this.hrac.getHp()) + " hp");
    }


    private void zablokujTlacidla() {
        for (JButton b : this.nepriatelia.keySet()) {
            b.setEnabled(false);
        }
        utokyBtn.setEnabled(false);
        magiaBtn.setEnabled(false);
        inventarBtn.setEnabled(false);
    }


    private void odomkniTlacidla() {
        for (JButton b : this.nepriatelia.keySet()) {
            b.setEnabled(true);
        }
        utokyBtn.setEnabled(true);
        magiaBtn.setEnabled(true);
        inventarBtn.setEnabled(true);
    }
}