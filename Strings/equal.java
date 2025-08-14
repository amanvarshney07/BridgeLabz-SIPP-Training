package Strings;

import java.util.Scanner;

public class equal {

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

        System.out.print("Enter the first string: ");
        String str1 = scanner.next();

        System.out.print("Enter the second string: ");
        String str2 = scanner.next();

        boolean resultCustom = compareUsingCharAt(str1, str2);

        boolean resultBuiltIn = str1.equals(str2);

        System.out.println("\nComparison using charAt(): " + resultCustom);
        System.out.println("Comparison using equals(): " + resultBuiltIn);

        if (resultCustom == resultBuiltIn) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("Methods give different results!");
        }
    }
}

