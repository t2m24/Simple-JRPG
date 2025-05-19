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
 * Okno zobrazované pri prehre hráča, keď stratí všetky životy.
 * Ponúka možnosť reštartu hry alebo jej ukončenia.
 */
public class ZomrelSiRamec {
    private JPanel panel1;
    private JButton restartButton;
    private JButton koniecButton;
    private JLabel zomrelSiLabel;

    /**
     * Vytvorí okno s oznámením o prehre a možnosťami pokračovania.
     * @param herneOkno Referencia na hlavné herné okno
     * @param konzolaOkno Referencia na konzolové okno
     */
    public ZomrelSiRamec(JFrame herneOkno, JFrame konzolaOkno) {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500, 500);

        this.zomrelSiLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.koniecButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.koniecButton.setPreferredSize(new Dimension(300, 80));
        this.restartButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.restartButton.setPreferredSize(new Dimension(300, 80));

        /**
         * Akcia pre tlačidlo Reštart - vráti hráča do hlavného menu a zatvorí všetky okná.
         */
        this.restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HlavneMenu();
                herneOkno.setVisible(false);
                herneOkno.dispose();
                konzolaOkno.setVisible(false);
                konzolaOkno.dispose();
                okno.setVisible(false);
                okno.dispose();
            }
        });

        /**
         * Akcia pre tlačidlo Koniec - definitívne ukončí aplikáciu a zatvorí všetky okná.
         */
        this.koniecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herneOkno.setVisible(false);
                herneOkno.dispose();
                konzolaOkno.setVisible(false);
                konzolaOkno.dispose();
                okno.setVisible(false);
                okno.dispose();
            }
        });

        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
    }
}
