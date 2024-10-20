package Exercise3;
import java.util.Scanner;

public class MortgageMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mortgage[] mortgages = new Mortgage[3];


        System.out.print("Enter the current prime interest rate: ");
        double primeRate = scanner.nextDouble();

        //loop to create and store 3 mortgages
        for (int i = 0; i < 3; i++) {
            System.out.println("\nEnter details for Mortgage #" + (i + 1) + ":");

            //get mortgage type
            System.out.print("Enter 1 for Business Mortgage or 2 for Personal Mortgage: ");
            int type = scanner.nextInt();


            System.out.print("Enter the mortgage number: ");
            String mortgageNumber = scanner.next();
            System.out.print("Enter the customer name: ");
            String customerName = scanner.next();
            System.out.print("Enter the mortgage amount: ");
            double mortgageAmount = scanner.nextDouble();
            System.out.print("Enter the mortgage term (1 for Short-Term, 3 for Medium-Term, 5 for Long-Term): ");
            int term = scanner.nextInt();

            //createing mortgage obj
            if (type == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, mortgageAmount, primeRate, term);
            }
        }

        // Display all
        System.out.println("\n--- All Mortgages ---");
        for (Mortgage mortgage : mortgages) {
            System.out.println(mortgage.getMortgageInfo());
            System.out.println();
        }

        scanner.close();
    }
}
