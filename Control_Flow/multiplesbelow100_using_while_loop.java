package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class multiplesbelow100_using_while_loop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number (positive and less than 100): ");
        int number = scanner.nextInt();

        if (number > 0 && number < 100) {
            int counter = 99;  // Start from 99 down to 1
            System.out.println("Multiples of " + number + " below 100 are:");

            while (counter > 1) {
                if (counter % number == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        scanner.close();
    }
}

