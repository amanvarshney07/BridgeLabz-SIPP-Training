package Strings;

import java.util.Scanner;

public class SubStringComparison {

    public static String createSubstringUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the original string: ");
        String input = scanner.next();

        System.out.print("Enter the start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end index: ");
        int end = scanner.nextInt();

        String substringCustom = createSubstringUsingCharAt(input, start, end);
        String substringBuiltIn = input.substring(start, Math.min(end, input.length())); // Handle out of bounds

        boolean areEqual = compareUsingCharAt(substringCustom, substringBuiltIn);

        System.out.println("\nSubstring using charAt(): " + substringCustom);
        System.out.println("Substring using substring(): " + substringBuiltIn);
        System.out.println("Are both substrings equal? " + areEqual);
    }
}

