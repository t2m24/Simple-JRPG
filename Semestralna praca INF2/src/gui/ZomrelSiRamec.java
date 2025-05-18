package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZomrelSiRamec {
    private JPanel panel1;
    private JButton restartButton;
    private JButton koniecButton;
    private JLabel zomrelSiLabel;

    public ZomrelSiRamec(JFrame herneOkno, JFrame konzolaOkno) {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500,500);

        this.zomrelSiLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.koniecButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.koniecButton.setPreferredSize(new Dimension(300, 80));
        this.restartButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.restartButton.setPreferredSize(new Dimension(300, 80));

        restartButton.addActionListener(new ActionListener() {
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

        koniecButton.addActionListener(new ActionListener() {
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
