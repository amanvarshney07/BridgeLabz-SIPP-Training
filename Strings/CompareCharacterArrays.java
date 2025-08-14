package Strings;

import java.util.Scanner;

public class CompareCharacterArrays {
    public static char[] getCharacters(String text) {
        char[] characters = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            characters[i] = text.charAt(i);
        }
        return characters;
    }

    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) return false;
        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        char[] manualChars = getCharacters(input);
        char[] builtInChars = input.toCharArray();

        boolean isSame = compareArrays(manualChars, builtInChars);

        System.out.println("\nCharacters from user-defined method:");
        for (char c : manualChars) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nCharacters from toCharArray():");
        for (char c : builtInChars) {
            System.out.print(c + " ");
        }

        System.out.println("\n\nAre both character arrays equal? " + isSame);
    }
}

