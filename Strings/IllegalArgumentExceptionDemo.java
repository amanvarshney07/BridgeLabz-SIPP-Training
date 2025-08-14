package Strings;

import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void generateException(String text) {
        System.out.println("\nGenerating IllegalArgumentException...");
        String result = text.substring(5, 2);
        System.out.println("Substring: " + result);
    }

    public static void handleException(String text) {
        try {
            System.out.println("\nHandling IllegalArgumentException safely...");
            String result = text.substring(5, 2);
            System.out.println("Substring: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        try {
            generateException(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception occurred in generateException(): " + e.getMessage());
        }
        handleException(input);
    }
}
