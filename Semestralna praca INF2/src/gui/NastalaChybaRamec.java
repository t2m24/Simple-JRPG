package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NastalaChybaRamec {
    private JPanel panel1;
    private JButton koniecButton;
    private JLabel nastalaChybaLabel;

    public NastalaChybaRamec() {
        JFrame okno = new JFrame();
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setContentPane(this.panel1);
        okno.setSize(500,500);

        this.nastalaChybaLabel.setFont(new Font("Arial", Font.BOLD, 40));
        this.koniecButton.setFont(new Font("Arial", Font.BOLD, 28));
        this.koniecButton.setPreferredSize(new Dimension(300, 80));

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
