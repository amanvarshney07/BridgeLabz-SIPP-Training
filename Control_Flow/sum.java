package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class sum{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        int sum = 0;

        while (true) {
            System.out.print("Enter a number: ");
            number = scanner.nextInt();

            if (number <= 0) {
                break;  // Exit the loop
            }

            sum += number;
        }

        System.out.println("Sum of entered positive numbers: " + sum);
        scanner.close();
    }
}

