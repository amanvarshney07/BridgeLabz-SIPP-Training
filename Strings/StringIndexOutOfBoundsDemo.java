package Strings;

import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateException(String text) {
        System.out.println("\nGenerating StringIndexOutOfBoundsException...");
        System.out.println("Character at invalid index: " + text.charAt(text.length()));
    }

 
    public static void handleException(String text) {
        try {
            System.out.println("\nHandling StringIndexOutOfBoundsException safely...");
            System.out.println("Character at invalid index: " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception occurred in generateException(): " + e.getMessage());
        }
        handleException(input);
    }
}

