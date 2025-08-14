package Strings;

import java.util.Scanner;

public class CharFrequencyASCII {

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

    public static String[][] getFrequency(String str) {
        int[] freq = new int[256];
        int len = getLength(str);

        for (int i = 0; i < len; i++) {
            freq[str.charAt(i)]++;
        }

        String[][] result = new String[256][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);
            if (freq[ch] > 0) {
                result[index][0] = String.valueOf(ch);
                result[index][1] = String.valueOf(freq[ch]);
                freq[ch] = 0;
                index++;
            }
        }

        String[][] finalResult = new String[index][2];
        for (int i = 0; i < index; i++) {
            finalResult[i][0] = result[i][0];
            finalResult[i][1] = result[i][1];
        }

        return finalResult;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[][] freq = getFrequency(input);
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + " = " + freq[i][1]);
        }
    }
}

