package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class NaturalNumberSumCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        if (n >= 1) {
            // Using formula
            int sumFormula = n * (n + 1) / 2;

            // Using while loop
            int sumLoop = 0;
            int i = 1;
            while (i <= n) {
                sumLoop += i;
                i++;
            }

            // Output
            System.out.println("Sum using formula: " + sumFormula);
            System.out.println("Sum using while loop: " + sumLoop);

            // Compare results
            if (sumFormula == sumLoop) {
                System.out.println("Both results match. Computation is correct.");
            } else {
                System.out.println("Results do not match. Please check the logic.");
            }
        } else {
            System.out.println("The number " + n + " is not a natural number.");
        }

        scanner.close();
    }
}

