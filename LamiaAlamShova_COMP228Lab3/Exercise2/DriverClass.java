package Exercise2;
import java.util.Scanner;

public class DriverClass {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the game tester's name: ");
            String name = scanner.nextLine();


            System.out.print("Enter 1 for Full-time or 2 for Part-time: ");
            int choice = scanner.nextInt();

            GameTester tester;

            if (choice == 1) {

                tester = new FullTimeGameTester(name);
            } else {

                System.out.print("Enter hours worked: ");
                int hours = scanner.nextInt();
                tester = new PartTimeGameTester(name, hours);
            }


            System.out.println("Salary: $" + tester.determineSalary());
            scanner.close();
        }
    }

