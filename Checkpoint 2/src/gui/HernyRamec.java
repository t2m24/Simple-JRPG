package gui;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HernyRamec extends JFrame {
    private JLabel stavLabel;
    private HernyPanel hernyPanel;
    private JPanel nepriateliaPanel;
    private JSplitPane nepriateliaSplit1;
    private JPanel hlavnyPanel;
    private JLabel vypis;
    private JLabel hpLabel;
    private JLabel manaLabel;

    public HernyRamec() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        this.inicializujGUI();
    }

    private void inicializujGUI() {
        setLayout(new BorderLayout());

        this.hernyPanel = new HernyPanel(this);
        add(this.hernyPanel, BorderLayout.CENTER);

        JPanel spodnyPanel = new JPanel();
        spodnyPanel.setLayout(new BorderLayout());

        this.stavLabel = new JLabel("Vlna 1");
        spodnyPanel.add(this.stavLabel, BorderLayout.NORTH);

        JPanel ovladaciPanel = new JPanel();
        ovladaciPanel.setLayout(new GridLayout(1, 3));

        JButton btnUtok = new JButton("Utok");
        JButton btnMagia = new JButton("Magia");
        JButton btnEnd = new JButton("Ukoncit");

        btnUtok.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.hernyPanel.utoc();
            }
        });

        btnMagia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                HernyRamec.this.hernyPanel.pouzitMagiu();
            }
        });

        btnEnd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ovladaciPanel.add(btnUtok);
        ovladaciPanel.add(btnMagia);
        ovladaciPanel.add(btnEnd);
        spodnyPanel.add(ovladaciPanel, BorderLayout.SOUTH);

        add(spodnyPanel, BorderLayout.SOUTH);
    }

    public void aktualizujStav(String sprava) {
        this.stavLabel.setText(sprava);
    }
}