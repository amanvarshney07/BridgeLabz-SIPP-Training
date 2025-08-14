package Strings;

import java.util.Scanner;

public class PalindromeCheck {

    public static int getLength(String str) {
        int i = 0;
        while (true) {
            boolean valid = false;
            for (char c = 32; c <= 126; c++) {
                if (i < 1000 && str.charAt(i) == c) {
                    valid = true;
                    break;
                }
            }
            if (!valid) break;
            i++;
        }
        return i;
    }

    public static boolean checkLoop(String str) {
        int len = getLength(str);
        int start = 0;
        int end = len - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static boolean checkRecursive(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return checkRecursive(str, start + 1, end - 1);
    }

    public static boolean checkReverseCompare(String str) {
        int len = getLength(str);
        char[] rev = new char[len];
        for (int i = 0; i < len; i++) {
            rev[i] = str.charAt(len - 1 - i);
        }
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != rev[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int len = getLength(text);

        boolean logic1 = checkLoop(text);
        boolean logic2 = checkRecursive(text, 0, len - 1);
        boolean logic3 = checkReverseCompare(text);

        System.out.println("Loop Method: " + (logic1 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive Method: " + (logic2 ? "Palindrome" : "Not Palindrome"));
        System.out.println("Reverse Compare: " + (logic3 ? "Palindrome" : "Not Palindrome"));
    }
}

