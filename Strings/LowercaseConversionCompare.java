package Strings;

import java.util.Scanner;

public class LowercaseConversionCompare {

    public static String convertToLower(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char)(ch + 32);
            } else {
                result += ch;
            }
        }
        return result;
    }
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = sc.nextLine();

        String builtInLower = input.toLowerCase();

        String manualLower = convertToLower(input);

        boolean areEqual = compareStrings(builtInLower, manualLower);

        System.out.println("\nConverted using built-in toLowerCase(): " + builtInLower);
        System.out.println("Converted using user-defined method:  " + manualLower);
        System.out.println("\nAre both conversions equal? " + areEqual);
    }
}

