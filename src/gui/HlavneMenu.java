package gui;

import postavy.Hrac;
import vlny.CitacVln;
import vlny.VlnaManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Hlavné menu hry, ktoré umožňuje spustiť novú hru, načítať vlny zo súboru alebo ukončiť aplikáciu.
 */
public class HlavneMenu {
    private JPanel panel1;
    private JButton startButton;
    private JButton nacitajVlnyButton;
    private JButton koniecButton;
    private JLabel nadpis;

    /**
     * Vytvorí hlavné menu s nastavenými tlačidlami a ich funkcionalitou.
     */
    public HlavneMenu() {
        JFrame okno = new JFrame("Hlavne menu");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500, 500);
        this.nadpis.setFont(new Font("Arial", Font.BOLD, 40));

        JButton[] tlacidla = {this.startButton, this.nacitajVlnyButton, this.koniecButton};
        for (JButton tlacitko : tlacidla) {
            tlacitko.setFont(new Font("Arial", Font.BOLD, 28));
            tlacitko.setPreferredSize(new Dimension(300, 80));
        }

        /**
         * Akcia pre tlačidlo Štart - spustí novú hru s predvolenými vlnami nepriateľov.
         */
        this.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VlnaManager vlnaManager = new VlnaManager();
                Hrac hrac = new Hrac();
                new HernyRamec(hrac, vlnaManager);
                okno.setVisible(false);
                okno.dispose();
            }
        });

        /**
         * Akcia pre tlačidlo Načítať vlny - umožní výber súboru s vlastnými vlnami nepriateľov.
         */
        this.nacitajVlnyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Frame fileDialogParent = new Frame();
                FileDialog fd = new FileDialog(fileDialogParent, "Vyberte súbor s vlnami", FileDialog.LOAD);
                fd.setFile("*.txt");
                fd.setVisible(true);

                String adresar = fd.getDirectory();
                String subor = fd.getFile();
                fileDialogParent.dispose();

                if (subor != null) {
                    File suborSVlnami = new File(adresar, subor);
                    try {
                        CitacVln citacVln = new CitacVln(suborSVlnami);
                        VlnaManager vlnaManager = new VlnaManager(citacVln.getNacitaneVlny());
                        Hrac hrac = new Hrac();
                        new HernyRamec(hrac, vlnaManager);
                    } catch (RuntimeException ex) {
                        System.err.println("Chyba pri načítaní vĺn: " + ex.getMessage());
                    }
                } else {
                    new NastalaChybaRamec();
                }
                okno.setVisible(false);
                okno.dispose();
            }
        });

        /**
         * Akcia pre tlačidlo Koniec - ukončí aplikáciu.
         */
        this.koniecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                okno.setVisible(false);
                okno.dispose();
            }
        });

        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }
}
