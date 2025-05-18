package gui;

import postavy.Hrac;
import postavy.nepriatelia.Goblin;
import postavy.nepriatelia.Ork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                Hrac hrac = new Hrac();
                Goblin g1 = new Goblin();
                Goblin g2 = new Goblin();
                Ork g3 = new Ork();
                Goblin g4 = new Goblin();
                HernyRamec hernyRamec = new HernyRamec(hrac, g1, g2, g3, g4, 1);
                okno.setVisible(false);
                okno.dispose();
            }
        });


        nacitajVlnyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //CitacSuborov citacSuborov = new CitacSuborov();
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
