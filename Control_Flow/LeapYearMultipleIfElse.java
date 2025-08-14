package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class LeapYearMultipleIfElse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year (>=1582): ");
        int year = scanner.nextInt();

        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar).");
        } else if (year % 400 == 0) {
            System.out.println(year + " is a Leap Year.");
        } else if (year % 100 == 0) {
            System.out.println(year + " is NOT a Leap Year.");
        } else if (year % 4 == 0) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is NOT a Leap Year.");
        }

        scanner.close();
    }
}

