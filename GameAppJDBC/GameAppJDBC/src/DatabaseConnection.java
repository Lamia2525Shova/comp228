import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {
    private static DatabaseConnection _dbHelper;
    private Connection dbConnection;
    private final String PLAYER_TABLE = "LAMIAALAM_PLAYER_GAME";
    private PreparedStatement insertStatement;
    private PreparedStatement selectStatement;

    // Singleton pattern to ensure only one instance of the helper
    public static DatabaseConnection getInstance() {
        if (_dbHelper == null) {
            _dbHelper = new DatabaseConnection();
        }
        return _dbHelper;
    }

    private DatabaseConnection() {
        this.connectToDB();
    }

    public static Connection getConnection() {
        return null;
    }

    // Connect to the database
    public void connectToDB() {
        try {
            String driverType = "jdbc:oracle:thin";
            String host = "@oracle1.centennialcollege.ca";
            int port = 1521;
            String sid = "SQLD";

            String hostString = driverType + ":" + host + ":" + port + ":" + sid;
            System.out.println("hostString : " + hostString);

            String username = "COMP228_F24_soh_33";
            String password = "helloLamia123"; // Use your actual password here

            // Register the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Establish the connection
            this.dbConnection = DriverManager.getConnection(hostString, username, password);

            if (this.dbConnection != null) {
                System.out.println("Database connection established successfully");
                this.createTable();
                this.prepareStatements();
            } else {
                System.out.println("Cannot get database connection.");
            }
        } catch (SQLException ex) {
            System.out.println("Error while connecting to database : " + ex);
        } catch (Exception ex) {
            System.out.println("Something went wrong : " + ex);
        }
    }

    // Method to create the table (if needed)
    private void createTable() {
        try {
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + PLAYER_TABLE + " (" +
                    "player_id INT PRIMARY KEY, " +
                    "first_name VARCHAR(50), " +
                    "last_name VARCHAR(50), " +
                    "game_title VARCHAR(100))";
            Statement stmt = dbConnection.createStatement();
            stmt.executeUpdate(createTableQuery);
        } catch (SQLException e) {
            System.out.println("Error creating table: " + e.getMessage());
        }
    }

    // Prepare SQL statements for inserting and selecting
    private void prepareStatements() {
        try {
            // Prepared statement for inserting new player-game data
            String insertQuery = "INSERT INTO " + PLAYER_TABLE + " (player_id, first_name, last_name, game_title) VALUES(?, ?, ?, ?)";
            this.insertStatement = this.dbConnection.prepareStatement(insertQuery);

            // Prepared statement for selecting player-game reports
            String selectQuery = "SELECT p.player_id, p.first_name, p.last_name, g.game_title " +
                    "FROM LAMIAALAM_PLAYER_GAME p " +
                    "JOIN PlayerAndGame pg ON p.player_id = pg.player_id " +
                    "JOIN Game g ON pg.game_id = g.game_id";
            this.selectStatement = this.dbConnection.prepareStatement(selectQuery);
        } catch (SQLException e) {
            System.out.println("Error preparing statements: " + e.getMessage());
        }
    }

    // Method to insert a new player-game relationship into the database
    public void insertPlayerGame(int playerId, String firstName, String lastName, String gameTitle) {
        try {
            insertStatement.setInt(1, playerId);
            insertStatement.setString(2, firstName);
            insertStatement.setString(3, lastName);
            insertStatement.setString(4, gameTitle);
            insertStatement.executeUpdate();
            System.out.println("Player-Game relationship inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }

    // Method to fetch player-game reports
    public List<PlayerGameReport> getPlayerGameReports() {
        List<PlayerGameReport> reports = new ArrayList<>();
        try (ResultSet rs = selectStatement.executeQuery()) {
            while (rs.next()) {
                int playerId = rs.getInt("player_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String gameTitle = rs.getString("game_title");
                reports.add(new PlayerGameReport(playerId, firstName, lastName, gameTitle));
            }
        } catch (SQLException e) {
            System.out.println("Error fetching reports: " + e.getMessage());
        }
        return reports;
    }
}

class PlayerGameReport {
    private int playerId;
    private String firstName;
    private String lastName;
    private String gameTitle;

    // Constructor
    public PlayerGameReport(int playerId, String firstName, String lastName, String gameTitle) {
        this.playerId = playerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gameTitle = gameTitle;
    }

    // Getters and Setters
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    @Override
    public String toString() {
        return "PlayerGameReport{" +
                "playerId=" + playerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gameTitle='" + gameTitle + '\'' +
                '}';
    }
}
