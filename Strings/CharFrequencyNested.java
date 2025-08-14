package Strings;

import java.util.Scanner;

public class CharFrequencyNested {

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

    public static String[][] getFrequency(String str) {
        int len = getLength(str);
        char[] characters = new char[len];
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            characters[i] = str.charAt(i);
            freq[i] = 1;
            for (int j = 0; j < i; j++) {
                if (characters[j] == characters[i]) {
                    freq[i] = 0;
                    break;
                }
            }
            if (freq[i] != 0) {
                for (int k = i + 1; k < len; k++) {
                    if (characters[k] == characters[i]) {
                        freq[i]++;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            if (freq[i] > 0) count++;
        }

        String[][] result = new String[count][2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (freq[i] > 0) {
                result[idx][0] = String.valueOf(characters[i]);
                result[idx][1] = String.valueOf(freq[i]);
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] result = getFrequency(input);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " = " + result[i][1]);
        }
    }
}

