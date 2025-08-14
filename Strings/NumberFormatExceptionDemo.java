package Strings;

import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void generateException(String text) {
        System.out.println("\nGenerating NumberFormatException...");
        int number = Integer.parseInt(text);
        System.out.println("Parsed number: " + number);
    }
    public static void handleException(String text) {
        try {
            System.out.println("\nHandling NumberFormatException safely...");
            int number = Integer.parseInt(text);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a text input: ");
        String input = sc.next();
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception occurred in generateException(): " + e.getMessage());
        }
        handleException(input);
    }
}

