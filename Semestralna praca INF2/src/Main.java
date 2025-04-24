import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        // Set the Napkin Look and Feel
        try {
            UIManager.setLookAndFeel("net.sourceforge.napkinlaf.NapkinLookAndFeel");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Start the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}