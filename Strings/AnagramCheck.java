package Strings;

import java.util.Scanner;

public class AnagramCheck {

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

    public static boolean isAnagram(String text1, String text2) {
        int len1 = getLength(text1);
        int len2 = getLength(text2);

        if (len1 != len2) return false;

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < len1; i++) {
            freq1[text1.charAt(i)]++;
            freq2[text2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        boolean result = isAnagram(text1, text2);

        if (result) {
            System.out.println("The texts are anagrams.");
        } else {
            System.out.println("The texts are not anagrams.");
        }
    }
}

