package lab2exercise2;


import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // Get the user's chosen number
        String userInput = JOptionPane.showInputDialog("Choose a number between 3 and 27:");
        int userNumber = Integer.parseInt(userInput);  // Parse user input to an integer

        int attempts = 0;
        boolean userWins = false;  // To track if user wins

        // Allow the user to play up to 5 times
        while (attempts < 5) {
            Lotto lotto = new Lotto();  // Create a new Lotto object
            int[] numbers = lotto.getGeneratedArray();  // Get the array of random numbers
            int lottoSum = lotto.getLottoSum();  // Calculate the sum of lotto numbers

            // Display the numbers and their sum to the user
            String message = "Lotto numbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]
                    + "\nLotto sum: " + lottoSum;
            JOptionPane.showMessageDialog(null, message);

            // Check if the sum matches the user's chosen number
            if (userNumber == lottoSum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won!");
                userWins = true;  // User wins, so set this to true
                break;  // Exit the loop since the user won
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, that's not the correct sum. Try again.");
            }

            attempts++;  // Increment attempts

            // If the user has had 5 tries and still hasn't won
            if (attempts == 5) {
                JOptionPane.showMessageDialog(null, "Sorry, you've used all your attempts. The computer wins!");
            }
        }
    }
}
