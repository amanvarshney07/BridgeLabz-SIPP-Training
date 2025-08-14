package Strings;

import java.util.Scanner;

public class StringTrimmer {

    public static int[] findTrimIndices(String str) {
        int start = 0, end = str.length() - 1;
        while (start < str.length() && str.charAt(start) == ' ') {
            start++;
        }
        while (end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    public static String manualSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += str.charAt(i);
        }
        return result;
    }

    public static boolean manualCompare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] bounds = findTrimIndices(input);
        String trimmedManual = manualSubstring(input, bounds[0], bounds[1]);
        String trimmedBuiltIn = input.trim();
        boolean isSame = manualCompare(trimmedManual, trimmedBuiltIn);
        System.out.println("Trimmed manually: '" + trimmedManual + "'");
        System.out.println("Trimmed using trim(): '" + trimmedBuiltIn + "'");
        System.out.println("Are both same? " + isSame);
    }
}

