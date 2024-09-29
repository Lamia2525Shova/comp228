package lab2exercise1;

import java.util.Random;
import javax.swing.JOptionPane;

public class Test {


    public int correctAnswers;
    public int wrongAnswers;
    public int numOfQuestions = 5;

    //list for questions
    public void questionBank(int questionBank) {
        String question;
        String[] options = new String[4];
        switch (questionBank + 1) {
            case 1:
                question = "Which of the following are not Java keywords?";
                options[0] = "1. double";
                options[1] = "2. then";
                options[2] = "3. instanceof";
                options[3] = "4. switch";
                checkAnswer(2, question, options);
                break;
            case 2:
                question = "Which one is a template for creating different objects?";
                options[0] = "1. Class";
                options[1] = "2. Array";
                options[2] = "3. Interface";
                options[3] = "4. None";
                checkAnswer(0, question, options);
                break;
            case 3:
                question = "What is the correct syntax for main method?";
                options[0] = "1. public static void main(String[] args)";
                options[1] = "2. static public void main(String[] args)";
                options[2] = "3. void public static main(String args[])";
                options[3] = "4. public void static main(String[] args)";
                checkAnswer(0, question, options);
                break;
            case 4:
                question = "What is inheritance in Java?";
                options[0] = "1. Copying of objects";
                options[1] = "2. Sharing properties between classes";
                options[2] = "3. Creating an instance";
                options[3] = "4. None";
                checkAnswer(1, question, options);
                break;
            case 5:
                question = "Which keyword is used to access members of the superclass?";
                options[0] = "1. super";
                options[1] = "2. extends";
                options[2] = "3. this";
                options[3] = "4. None";
                checkAnswer(0, question, options);
                break;
        }
    }
    public void checkAnswer(int correctIndex, String question, String[] options) {
        String input = JOptionPane.showInputDialog(null, question + "\n" +
                options[0] + "\n" +
                options[1] + "\n" +
                options[2] + "\n" +
                options[3], "Question", JOptionPane.QUESTION_MESSAGE);

        int userAnswer = Integer.parseInt(input) - 1; // User input is 1-based index
        if (userAnswer == correctIndex) {
            JOptionPane.showMessageDialog(null, generateMessage(true));
            correctAnswers++;
        } else {
            JOptionPane.showMessageDialog(null, generateMessage(false) + "\nCorrect answer: " + (correctIndex + 1));
            wrongAnswers++;
        }
    }

    public String generateMessage(boolean isCorrect) {
        Random random = new Random();
        String message;
        switch (random.nextInt(4)) {
            case 0:
                message = isCorrect ? "Excellent!" : "No. Please try again.";
                break;
            case 1:
                message = isCorrect ? "Good job!" : "Wrong. Try again.";
                break;
            case 2:
                message = isCorrect ? "Keep up the good work!" : "Don't give up!";
                break;
            default:
                message = isCorrect ? "Nice work!" : "No. Keep trying.";
                break;
        }
        return message;
    }
    // Method to display final results
    public void displayResult() {
        int percentage = (correctAnswers * 100) / numOfQuestions;
        JOptionPane.showMessageDialog(null, "Correct Answers: " + correctAnswers +
                "\nWrong Answers: " + wrongAnswers +
                "\nScore: " + percentage + "%");
    }

}

