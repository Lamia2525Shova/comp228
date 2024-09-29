package lab2exercise2;

import java.util.Random;

public class Lotto {
    private int[] generatedArray;

    public Lotto() {
        Random random = new Random();
        generatedArray = new int[3];  // array to hold 3 random numbers


        generatedArray[0] = random.nextInt(9) + 1;
        generatedArray[1] = random.nextInt(9) + 1;
        generatedArray[2] = random.nextInt(9) + 1;
    }


    public int[] getGeneratedArray() {
        return generatedArray;
    }

    //calculating and returning the sum of the lotto numbers
    public int getLottoSum() {
        return generatedArray[0] + generatedArray[1] + generatedArray[2];
    }
}

