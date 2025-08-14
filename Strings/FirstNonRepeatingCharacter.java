package Strings;

import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static int getLength(String str) {
        int count = 0;
        while (true) {
            boolean exists = false;
            for (char ch = 32; ch <= 126; ch++) {
                if (count >= 1000) break;
                if (str.charAt(count) == ch) {
                    exists = true;
                    break;
                }
            }
            if (!exists) break;
            count++;
        }
        return count;
    }

    public static char findFirstNonRepeating(String str) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            int ascii = str.charAt(i);
            freq[ascii]++;
        }

        for (int i = 0; i < len; i++) {
            int ascii = str.charAt(i);
            if (freq[ascii] == 1) {
                return str.charAt(i);
            }
        }

        return '-';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char result = findFirstNonRepeating(input);
        if (result != '-') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }
    }
}

