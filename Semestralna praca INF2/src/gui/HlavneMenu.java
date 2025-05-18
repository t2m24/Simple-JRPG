package gui;

import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Ork;
import vlny.CitacVln;
import vlny.Vlna;
import vlny.VlnaManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class HlavneMenu {
    private JPanel panel1;
    private JButton startButton;
    private JButton nacitajVlnyButton;
    private JButton koniecButton;
    private JLabel nadpis;


    public HlavneMenu() {
        JFrame okno = new JFrame("Hlavne menu");
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500,500);
        this.nadpis.setFont(new Font("Arial", Font.BOLD, 40));

        JButton[] tlacidla = {startButton, nacitajVlnyButton, koniecButton};
        for (JButton tlacitko : tlacidla) {
            //nieje moj kod
            tlacitko.setFont(new Font("Arial", Font.BOLD, 28));
            tlacitko.setPreferredSize(new Dimension(300, 80));
        }

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VlnaManager vlnaManager = new VlnaManager();
                Hrac hrac = new Hrac();
                HernyRamec hernyRamec = new HernyRamec(hrac, vlnaManager);
                okno.setVisible(false);
                okno.dispose();
            }
        });


        nacitajVlnyButton.addActionListener(new ActionListener() {
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


        koniecButton.addActionListener(new ActionListener() {
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
