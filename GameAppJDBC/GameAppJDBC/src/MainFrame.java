import javax.swing.*;
import java.awt.*;

class MainFrame extends JFrame {
    private JPanel mainPanel;

    public MainFrame() {
        setTitle("Game Player Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JButton addButton = new JButton("Add Game/Player Info");
        JButton updateButton = new JButton("Update Player Info");
        JButton reportButton = new JButton("View Reports");

        addButton.addActionListener(e -> new AddInfoFrame());
        updateButton.addActionListener(e -> new UpdateInfoFrame());
        reportButton.addActionListener(e -> new ReportFrame());

        mainPanel.add(addButton);
        mainPanel.add(updateButton);
        mainPanel.add(reportButton);

        add(mainPanel);
        setVisible(true);
    }
}
