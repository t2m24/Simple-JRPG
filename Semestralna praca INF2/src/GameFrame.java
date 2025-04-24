import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class GameFrame extends JFrame {
    private JLabel statusLabel;
    private GamePanel gamePanel;

    public GameFrame() {
        setTitle("Turn-based RPG Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        initGUI();
    }

    private void initGUI() {
        // A status label at the bottom for game messages
        statusLabel = new JLabel("Welcome to the RPG Game!");
        add(statusLabel, BorderLayout.SOUTH);

        // The main game panel in the center
        gamePanel = new GamePanel(this);
        add(gamePanel, BorderLayout.CENTER);
    }

    public void updateStatus(String message) {
        statusLabel.setText(message);
    }
}