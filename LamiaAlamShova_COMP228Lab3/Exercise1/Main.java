package Exercise1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //hold insurance objects
        Insurance[] insurances = new Insurance[2];

        //user input
        Scanner scanner = new Scanner(System.in);

        //input for Life insurance
        System.out.println("Enter the monthly fee for Life Insurance: ");
        double lifeCost = scanner.nextDouble();
        Insurance lifeInsurance = new Life();
        lifeInsurance.setInsuranceCost(lifeCost);
        insurances[0] = lifeInsurance;

        //input for Health insurance
        System.out.println("Enter the monthly fee for Health Insurance: ");
        double healthCost = scanner.nextDouble();
        Insurance healthInsurance = new Health();
        healthInsurance.setInsuranceCost(healthCost);
        insurances[1] = healthInsurance;

        //polymorphic screen manager
        System.out.println("\n--- Insurance Details ---");
        for (Insurance insurance : insurances) {
            insurance.displayInfo();
            System.out.println();
        }

        scanner.close();
    }
}
