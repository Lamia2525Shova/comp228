import javax.swing.*;
import java.awt.*;
import java.sql.*;

class AddInfoFrame extends JFrame {
    private JTextField gameTitleField, firstNameField, lastNameField;

    public AddInfoFrame() {
        setTitle("Add Information");
        setSize(400, 300);
        setLayout(new GridLayout(4, 2));

        // Labels and text fields
        JLabel gameLabel = new JLabel("Game Title:");
        gameTitleField = new JTextField();

        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();

        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveData());

        // Add components to the frame
        add(gameLabel);
        add(gameTitleField);
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(saveButton);

        // Make the frame visible
        setVisible(true);
    }

    private void saveData() {
        String gameTitle = gameTitleField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();

        if (gameTitle.isEmpty() || firstName.isEmpty() || lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return; // Exit method if any field is empty
        }

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Insert game into the Game table
            String gameQuery = "INSERT INTO Game (game_title) VALUES (?)";
            try (PreparedStatement gameStmt = conn.prepareStatement(gameQuery, Statement.RETURN_GENERATED_KEYS)) {
                gameStmt.setString(1, gameTitle);
                gameStmt.executeUpdate();

                // Get the generated game ID
                ResultSet gameKeys = gameStmt.getGeneratedKeys();
                int gameId = 0;
                if (gameKeys.next()) {
                    gameId = gameKeys.getInt(1);
                }

                // Insert player into the Player table
                String playerQuery = "INSERT INTO Player (first_name, last_name) VALUES (?, ?)";
                try (PreparedStatement playerStmt = conn.prepareStatement(playerQuery)) {
                    playerStmt.setString(1, firstName);
                    playerStmt.setString(2, lastName);
                    playerStmt.executeUpdate();
                }

                // Show success message
                JOptionPane.showMessageDialog(this, "Data Saved Successfully!");
                dispose();  // Close the frame after saving data

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database connection error: " + ex.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
