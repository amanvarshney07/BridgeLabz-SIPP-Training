package Strings;

import java.util.Scanner;

public class CharFrequencyUnique {

    public static int getLength(String str) {
        int i = 0;
        while (true) {
            boolean found = false;
            for (char c = 32; c <= 126; c++) {
                if (i < 1000 && str.charAt(i) == c) {
                    found = true;
                    break;
                }
            }
            if (!found) break;
            i++;
        }
        return i;
    }

    public static char[] getUniqueChars(String str) {
        int len = getLength(str);
        char[] unique = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean exists = false;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                unique[index++] = current;
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static String[][] getFrequencies(String str, char[] uniqueChars) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            freq[str.charAt(i)]++;
        }

        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] unique = getUniqueChars(input);
        String[][] freq = getFrequencies(input, unique);
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + " = " + freq[i][1]);
        }
    }
}

