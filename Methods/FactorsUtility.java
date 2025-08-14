package Methods;

import java.util.*;

public class FactorsUtility {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = getFactors(number);
        System.out.println("Factors: " + Arrays.toString(factors));
        System.out.println("Greatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cubes of Factors: " + findProductOfCubes(factors));
    }

    public static int[] getFactors(int number) {
        int count = 0;

        // Count number of factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                count++;
        }

        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0)
                factors[index++] = i;
        }

        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int max = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > max)
                max = factors[i];
        }
        return max;
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors)
            sum += factor;
        return sum;
    }

    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int factor : factors)
            product *= factor;
        return product;
    }

    public static long findProductOfCubes(int[] factors) {
        long product = 1;
        for (int factor : factors)
            product *= Math.pow(factor, 3);
        return product;
    }
}

