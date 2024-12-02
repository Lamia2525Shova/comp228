import javax.swing.*;
import java.awt.*;
import java.sql.*;


class ReportFrame extends JFrame {
    public ReportFrame() {
        setTitle("Player Reports");
        setSize(600, 400);
        setLayout(new BorderLayout());

        JTextArea reportArea = new JTextArea();
        reportArea.setEditable(false); // Make sure the JTextArea is not editable by the user
        add(new JScrollPane(reportArea), BorderLayout.CENTER);

        try (Connection conn = DatabaseConnection.getConnection()) {
            String query = "SELECT p.player_id, p.first_name, p.last_name, g.game_title " +
                    "FROM LAMIAALAM_PLAYER_GAME p " +
                    "JOIN PlayerAndGame pg ON p.player_id = pg.player_id " +
                    "JOIN Game g ON pg.game_id = g.game_id";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append("Player ID: ").append(rs.getInt("player_id"))
                        .append(", Name: ").append(rs.getString("first_name"))
                        .append(" ").append(rs.getString("last_name"))
                        .append(", Game: ").append(rs.getString("game_title")).append("\n");
            }
            reportArea.setText(sb.toString());
        } catch (SQLException ex) {
            reportArea.setText("Error fetching data: " + ex.getMessage());
            ex.printStackTrace(); // Optionally log the error in the console
        }

        setVisible(true);
    }
}
