import javax.swing.SwingUtilities;

public class GamePlayerApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}
