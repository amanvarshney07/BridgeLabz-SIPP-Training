package Strings;

import java.util.Scanner;

public class StringSplitCompare {

    public static boolean isValidIndex(String text, int index) {
        char[] arr = text.toCharArray();
        return index >= 0 && index < arr.length;
    }

    public static int getLength(String text) {
        int count = 0;
        while (isValidIndex(text, count)) {
            count++;
        }
        return count;
    }

    public static String substring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static String[] splitWords(String text) {
        int len = getLength(text);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') spaceCount++;
        }

        String[] words = new String[spaceCount + 1];
        int start = 0, wordIndex = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[wordIndex++] = substring(text, start, i);
                start = i + 1;
            }
        }

        words[wordIndex] = substring(text, start, len);
        return words;
    }

    public static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a line of text: ");
        String input = sc.nextLine();

        String[] builtInWords = input.split(" ");
        String[] manualWords = splitWords(input);

        boolean areEqual = compareArrays(builtInWords, manualWords);

        System.out.println("\nBuilt-in split() words:");
        for (String word : builtInWords) {
            System.out.println(word);
        }

        System.out.println("\nUser-defined split words:");
        for (String word : manualWords) {
            System.out.println(word);
        }

        System.out.println("\nAre both arrays equal? " + areEqual);
    }
}

