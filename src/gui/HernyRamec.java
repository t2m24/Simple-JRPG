package gui;

import postavy.Hrac;
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
import vlny.Vlna;
import vlny.VlnaManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

/**
 * Hlavné herné okno obsahujúce hernú logiku a používateľské rozhranie.
 * Spravuje interakciu medzi hráčom a nepriateľmi.
 */
public class HernyRamec {
    private final VlnaManager vlnaManager;
    private final HashMap<JButton, Nepriatel> nepriatelia;
    private final Hrac hrac;
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

    /**
     * Vytvorí herný rámec s daným hráčom a správcom vĺn.
     * @param hrac Hráč
     * @param vlnaManager Správca vĺn nepriateľov
     */
    public HernyRamec(Hrac hrac, VlnaManager vlnaManager) {
        this.vlnaManager = vlnaManager;
        this.hrac = hrac;
        this.nepriatelia = new HashMap<>();

        Vlna aktualnaVlna;
        try {
            aktualnaVlna = this.vlnaManager.dajDalsiuVlnu();
        } catch (Exception e) {
            new NastalaChybaRamec();
            System.out.println(e.getMessage());
            return;
        }


        this.okno = new JFrame(aktualnaVlna.getVypis());
        this.okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.okno.setContentPane(this.hlavnyPanel);

        this.nastavObrazokTlacidlu(this.nepriatelBtn1, aktualnaVlna.getNepriatel1());
        this.nastavObrazokTlacidlu(this.nepriatelBtn2, aktualnaVlna.getNepriatel2());
        this.nastavObrazokTlacidlu(this.nepriatelBtn3, aktualnaVlna.getNepriatel3());
        this.nastavObrazokTlacidlu(this.nepriatelBtn4, aktualnaVlna.getNepriatel4());

        //praca s JTextArea odvodena z tutorialu https://www.geeksforgeeks.org/java-swing-jtextarea/
        this.konzola = new JTextArea(20, 40);
        this.konzola.setEditable(false);
        this.konzola.setLineWrap(true);
        this.konzola.setWrapStyleWord(true);

        this.konzolaOkno = new JFrame("Konzola");
        this.konzolaOkno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.konzolaOkno.add(new JScrollPane(this.konzola));

        this.nepriatelia.put(this.nepriatelBtn1, aktualnaVlna.getNepriatel1());
        this.nepriatelia.put(this.nepriatelBtn2, aktualnaVlna.getNepriatel2());
        this.nepriatelia.put(this.nepriatelBtn3, aktualnaVlna.getNepriatel3());
        this.nepriatelia.put(this.nepriatelBtn4, aktualnaVlna.getNepriatel4());

        this.hpProgressBar.setMaximum(hrac.getMaxHp());
        this.hpProgressBar.setValue(hrac.getHp());

        this.manaProgressBar.setMaximum(hrac.getMaxMana());
        this.manaProgressBar.setValue(hrac.getMana());

        this.zobrazHp();
        this.zobrazManu();
        this.nastavVypis(aktualnaVlna.getVypis());

        JPopupMenu utokyMenu = new JPopupMenu();
        JMenuItem seknutie = new JMenuItem("Seknutie - Zakladny utok");
        JMenuItem bodnutie = new JMenuItem("Bodnutie");
        utokyMenu.add(seknutie);
        utokyMenu.add(bodnutie);

        this.utokyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utokyMenu.show(HernyRamec.this.utokyBtn, 0, HernyRamec.this.utokyBtn.getHeight());
            }
        });

        seknutie.addActionListener(e -> {
            this.zvolenyUtok = new Seknutie();
            this.nastavVypis("Zvoleny utok: " + this.zvolenyUtok.getNazov());
        });

        bodnutie.addActionListener(e -> {
            this.zvolenyUtok = new Bodnutie();
            this.nastavVypis("Zvoleny utok: " + this.zvolenyUtok.getNazov());
        });

        JPopupMenu magiaMenu = new JPopupMenu();
        JMenuItem ohnivaGula = new JMenuItem("Ohniva gula - Sposobi poskodenie, 10 mana");
        JMenuItem meteorit = new JMenuItem("Meteorit - Sposobi velke poskoenie, 30 mana");
        magiaMenu.add(ohnivaGula);
        magiaMenu.add(meteorit);

        this.magiaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                magiaMenu.show(HernyRamec.this.magiaBtn, 0, HernyRamec.this.magiaBtn.getHeight());
            }
        });

        ohnivaGula.addActionListener(e -> {
            this.zvolenyUtok = new OhnivaGula();
            this.nastavVypis("Zvolena magicka schopnost: " + this.zvolenyUtok.getNazov());
        });

        meteorit.addActionListener(e -> {
            this.zvolenyUtok = new Meteorit();
            this.nastavVypis("Zvolená magicka schopnosť: " + this.zvolenyUtok.getNazov());
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
                inventarMenu.show(HernyRamec.this.inventarBtn, 0, HernyRamec.this.inventarBtn.getHeight());
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


        this.nepriatelBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.vykonajUtokNaNepriatela(HernyRamec.this.nepriatelBtn1);
            }
        });

        this.nepriatelBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.vykonajUtokNaNepriatela(HernyRamec.this.nepriatelBtn2);
            }
        });

        this.nepriatelBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.vykonajUtokNaNepriatela(HernyRamec.this.nepriatelBtn3);
            }
        });

        this.nepriatelBtn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.vykonajUtokNaNepriatela(HernyRamec.this.nepriatelBtn4);
            }
        });

        //Praca s fontom oddvodená z tutorialu, pouzivana v gui triedach https://www.tutorialspoint.com/how-to-change-jlabel-font-in-java
        Font nepriatelFont = new Font("Arial", Font.BOLD, 16);
        this.nepriatelBtn1.setFont(nepriatelFont);
        this.nepriatelBtn2.setFont(nepriatelFont);
        this.nepriatelBtn3.setFont(nepriatelFont);
        this.nepriatelBtn4.setFont(nepriatelFont);

        Font tlacidlaFont = new Font("Arial", Font.BOLD, 18);
        this.utokyBtn.setFont(tlacidlaFont);
        this.magiaBtn.setFont(tlacidlaFont);
        this.inventarBtn.setFont(tlacidlaFont);

        Font stavFont = new Font("Arial", Font.BOLD, 16);
        this.hpLabel.setFont(stavFont);
        this.manaLabel.setFont(stavFont);

        Font vypisFont = new Font("Arial", Font.ITALIC, 16);
        this.vypis.setFont(vypisFont);

        this.vypis.setForeground(Color.BLUE);
        this.hpLabel.setForeground(new Color(200, 0, 0));
        this.manaLabel.setForeground(new Color(0, 0, 200));

        this.okno.setSize(1280, 720);
        this.okno.setLocationRelativeTo(null);
        this.okno.setVisible(true);

        this.konzolaOkno.pack();
        this.konzolaOkno.setVisible(true);

        //Praca s poziciami okien z dokumentacie https://docs.oracle.com/javase/8/docs/api/java/awt/Component.html#getLocation--
        Point hlavneOknoPozicia = this.okno.getLocation();
        int hlavneOknoSirka = this.okno.getWidth();
        this.konzolaOkno.setLocation(hlavneOknoPozicia.x + hlavneOknoSirka, hlavneOknoPozicia.y);
    }

    //Nastavenie ikony tlacidla odvodene z tutorialu https://www.tutorialspoint.com/swing/swing_imageicon.htm
    private void nastavObrazokTlacidlu(JButton tlacidlo, Nepriatel nepriatel) {
        ImageIcon ikona = new ImageIcon(Objects.requireNonNull(HernyRamec.class.getResource(nepriatel.getCestaKObrazku())));
        Image scaled = ikona.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        tlacidlo.setIcon(new ImageIcon(scaled));
        this.aktualizujTlacidloNepriatela(nepriatel, tlacidlo);
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

    private void vypisDoKonzoly(String sprava) {
        this.konzola.append(sprava + "\n");
        this.konzola.setCaretPosition(this.konzola.getDocument().getLength());
    }


    private void vykonajUtokNaNepriatela(JButton tlacidlo) {
        Nepriatel nepriatel = this.nepriatelia.get(tlacidlo);
        if (!this.hrac.jeNazive()) {
            return;
        }
        if (this.zvolenyUtok == null) {
            this.nastavVypis("Najprv si vyber útok!");
            return;
        }
        if (this.hrac.getMana() < this.zvolenyUtok.getCenaMany()) {
            this.nastavVypis("Nedostatok many!");
            return;
        }
        this.zvolenyUtok.vykonaj(this.hrac, nepriatel);
        this.vypisDoKonzoly(this.zvolenyUtok.getVypis());
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
            new ZomrelSiRamec(this.okno, this.konzolaOkno);
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
            new VlnaPorazenaRamec(this.hrac , this.vlnaManager, this.okno, this.konzolaOkno);
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
        this.utokyBtn.setEnabled(false);
        this.magiaBtn.setEnabled(false);
        this.inventarBtn.setEnabled(false);
    }
}