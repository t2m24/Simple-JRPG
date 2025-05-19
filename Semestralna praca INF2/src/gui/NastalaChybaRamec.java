package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno zobrazované pri výskyte chyby v aplikácii.
 */
public class NastalaChybaRamec {
    private JPanel panel1;
    private JButton koniecButton;
    private JLabel nastalaChybaLabel;

    /**
     * Vytvorí a zobrazí chybové okno s tlačidlom pre zavretie okna.
     */
    public NastalaChybaRamec() {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500, 500);

        this.nastalaChybaLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.koniecButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.koniecButton.setPreferredSize(new Dimension(300, 80));

        /**
         * Akcia pre tlačidlo Koniec - zavrie chybové okno.
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
