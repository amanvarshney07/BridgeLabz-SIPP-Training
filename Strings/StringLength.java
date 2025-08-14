package Strings;

import java.util.Scanner;

public class StringLength {

    public static boolean isValidIndex(String text, int index) {
        char[] chars = text.toCharArray();
        return index >= 0 && index < chars.length;
    }

    public static int getLength(String text) {
        int count = 0;
        while (isValidIndex(text, count)) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int customLength = getLength(input);
        int builtInLength = input.length();

        System.out.println("\nCustom calculated length: " + customLength);
        System.out.println("Built-in method length:    " + builtInLength);
    }
}
