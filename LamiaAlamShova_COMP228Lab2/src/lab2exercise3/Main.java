package lab2exercise3;
public class Main {
    public static void main(String[] args) {
        //method with two integers
        int result1 = Multiplication.multiply(5, 7);
        System.out.println("Multiplication of 5 and 7 (int): " + result1);

        //method with two doubles
        double result2 = Multiplication.multiply(5.5, 3.2);
        System.out.println("Multiplication of 5.5 and 3.2 (double): " + result2);

        //method with three integers
        int result3 = Multiplication.multiply(2, 3, 4);
        System.out.println("Multiplication of 2, 3, and 4 (int): " + result3);
    }
}




