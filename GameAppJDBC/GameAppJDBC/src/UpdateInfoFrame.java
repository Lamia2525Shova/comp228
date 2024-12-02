import javax.swing.*;
import java.awt.*;
import java.sql.*;

class UpdateInfoFrame extends JFrame {
    private JTextField playerIdField, addressField, phoneField;

    public UpdateInfoFrame() {
        setTitle("Update Player Info");
        setSize(400, 200);
        setLayout(new GridLayout(3, 2));

        JLabel playerIdLabel = new JLabel("Player ID:");
        playerIdField = new JTextField();

        JLabel addressLabel = new JLabel("Address:");
        addressField = new JTextField();

        JLabel phoneLabel = new JLabel("Phone:");
        phoneField = new JTextField();

        JButton updateButton = new JButton("Update");
        updateButton.addActionListener(e -> updatePlayerInfo());

        add(playerIdLabel);
        add(playerIdField);
        add(addressLabel);
        add(addressField);
        add(phoneLabel);
        add(phoneField);
        add(updateButton);

        setVisible(true);
    }

    private void updatePlayerInfo() {
        int playerId = Integer.parseInt(playerIdField.getText());
        String address = addressField.getText();
        String phone = phoneField.getText();

        try (Connection conn = DatabaseConnection.getConnection()) {
            String updateQuery = "UPDATE Player SET address = ?, phone_number = ? WHERE player_id = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);
            stmt.setString(1, address);
            stmt.setString(2, phone);
            stmt.setInt(3, playerId);
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(this, "Player Info Updated!");
            dispose();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
