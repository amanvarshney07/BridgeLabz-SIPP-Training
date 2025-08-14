package Arrays;

import java.util.Scanner;

public class BMI_in_the_2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3]; // [weight, height, BMI]
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Person " + (i + 1));
            double weight = 0, height = 0;

            while (true) {
                System.out.print("Enter weight (kg): ");
                weight = sc.nextDouble();
                if (weight > 0) break;
                System.out.println("Please enter a positive weight.");
            }
            while (true) {
                System.out.print("Enter height (m): ");
                height = sc.nextDouble();
                if (height > 0) break;
                System.out.println("Please enter a positive height.");
            }

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height); // BMI calculation

            double bmi = personData[i][2];

            if (bmi < 18.5)
                weightStatus[i] = "Underweight";
            else if (bmi < 24.9)
                weightStatus[i] = "Normal weight";
            else if (bmi < 29.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        System.out.println("\nResults:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s%n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}

