import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GamePanel extends JPanel {
    private GameFrame gameFrame;
    private Hrac player;
    private Nepriatel enemy;

    // Using the polymorphic indicators to display HP and mana
    private Ukazovatel hpIndicator;
    private Ukazovatel manaIndicator;
    private Ukazovatel enemyHpIndicator;

    public GamePanel(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
        setFocusable(true);
        requestFocusInWindow();

        // Initialize game entities with sample values
        player = new Hrac("Hero", 100, 50);
        enemy = new Goblin("Goblin", 50, 20);

        // Create indicators based on the interface
        hpIndicator = new UkazovatelZivotov(player);
        manaIndicator = new UkazovatelMany(player);
        enemyHpIndicator = new UkazovatelZivotov(enemy);

        addKeyListener(new KeyHandler());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Fill the background with a light color
        g.setColor(new Color(230, 230, 250));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Display player information
        g.setColor(Color.BLACK);
        g.drawString("Player: " + player.getMeno(), 20, 20);
        g.drawString(hpIndicator.getDisplay(), 20, 40);
        g.drawString(manaIndicator.getDisplay(), 20, 60);

        // Display enemy information
        g.drawString("Enemy: " + enemy.getMeno(), 300, 20);
        g.drawString(enemyHpIndicator.getDisplay(), 300, 40);
    }

    // A simple key listener to process player's actions using arrow keys
    private class KeyHandler extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();

            if (key == KeyEvent.VK_UP) {
                // Physical attack when the UP key is pressed
                player.utok(enemy);
                gameFrame.updateStatus("Player attacked the enemy!");
            } else if (key == KeyEvent.VK_DOWN) {
                // Magic attack when the DOWN key is pressed (if enough mana)
                if (player.getMana() >= 10) {
                    player.castMagic(enemy);
                    gameFrame.updateStatus("Player cast a spell!");
                } else {
                    gameFrame.updateStatus("Not enough mana to cast magic!");
                }
            }
            // Refresh the panel to update HP and mana displays
            repaint();
        }
    }
}