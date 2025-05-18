package gui;

import postavy.Hrac;
import vlny.VlnaManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Okno zobrazované po porazení vlny nepriateľov.
 * Ponúka možnosť pokračovať v hre alebo ju ukončiť.
 */
public class VlnaPorazenaRamec {
    private JPanel panel1;
    private JButton pokracovatButton;
    private JButton koniecButton;
    private JLabel vlnaPorazenaLabel;

    /**
     * Vytvorí okno s oznámením o porazení vlny a možnosťami pokračovania.
     * @param hrac Hráč s aktuálnymi štatistikami
     * @param vlnaManager Správca vĺn pre kontrolu progresu
     * @param herneOkno Referencia na hlavné herné okno
     * @param konzolaOkno Referencia na konzolové okno
     */
    public VlnaPorazenaRamec(Hrac hrac, VlnaManager vlnaManager, JFrame herneOkno, JFrame konzolaOkno) {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500, 500);

        this.vlnaPorazenaLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.koniecButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.koniecButton.setPreferredSize(new Dimension(300, 80));
        this.pokracovatButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.pokracovatButton.setPreferredSize(new Dimension(300, 80));

        /**
         * Akcia pre tlačidlo Pokračovať - buď spustí ďalšiu vlnu alebo prejde na výherné okno.
         */
        this.pokracovatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                herneOkno.setVisible(false);
                herneOkno.dispose();
                konzolaOkno.setVisible(false);
                konzolaOkno.dispose();
                okno.setVisible(false);
                okno.dispose();
                if (vlnaManager.bolaVlnaPosledna()) {
                    new VyhralSiRamec();
                } else {
                    new HernyRamec(hrac, vlnaManager);
                }
            }
        });

        /**
         * Akcia pre tlačidlo Koniec - ukončí hru a zavrie všetky okná.
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