package lab2exercise2;


import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        // asking user choice
        String userInput = JOptionPane.showInputDialog("Choose a number between 3 and 27:");
        int userNumber = Integer.parseInt(userInput);

        int attempts = 0;
        boolean userWins = false;

        //user to play up to 5 times
        while (attempts < 5) {
            Lotto lotto = new Lotto();
            int[] numbers = lotto.getGeneratedArray();
            int lottoSum = lotto.getLottoSum();

            //numbers and their sum to the user
            String message = "Lotto numbers: " + numbers[0] + ", " + numbers[1] + ", " + numbers[2]
                    + "\nLotto sum: " + lottoSum;
            JOptionPane.showMessageDialog(null, message);

            // Check if the user is wining or not
            //exit the loop when user wins
            if (userNumber == lottoSum) {
                JOptionPane.showMessageDialog(null, "Congratulations! You've won!");
                userWins = true;
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Sorry, that's not the correct sum. Try again.");
            }

            attempts++;


            if (attempts == 5) {
                JOptionPane.showMessageDialog(null, "Sorry, you've used all your attempts. The computer wins!");
            }
        }
    }
}
