package lab2exercise1;

public class Main {
    public static void main(String[] args) {
        Test quiz = new Test();

        for (int i = 0; i < quiz.numOfQuestions; i++) {
            quiz.questionBank(i);
        }

        quiz.displayResult();
    }
}

