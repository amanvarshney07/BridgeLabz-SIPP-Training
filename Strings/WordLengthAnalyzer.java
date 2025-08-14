package Strings;

import java.util.Scanner;

public class WordLengthAnalyzer {

    public static int getLength(String str) {
        int count = 0;
        while (true) {
            if (count < str.length()) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static String[] manualSplit(String str) {
        String[] words = new String[100];
        int wordIndex = 0;
        String current = "";
        for (int i = 0; i < getLength(str); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                current += ch;
            } else if (!current.equals("")) {
                words[wordIndex++] = current;
                current = "";
            }
        }
        if (!current.equals("")) {
            words[wordIndex++] = current;
        }
        String[] result = new String[wordIndex];
        for (int i = 0; i < wordIndex; i++) {
            result[i] = words[i];
        }
        return result;
    }

    public static String[][] getWordLengthArray(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            int len = 0;
            for (int j = 0; j < words[i].length(); j++) {
                len++;
            }
            data[i][1] = String.valueOf(len);
        }
        return data;
    }

    public static String[] getShortestAndLongest(String[][] wordData) {
        int minLen = 1000, maxLen = -1;
        String minWord = "", maxWord = "";
        for (int i = 0; i < wordData.length; i++) {
            int len = 0;
            String lenStr = wordData[i][1];
            for (int j = 0; j < lenStr.length(); j++) {
                len = len * 10 + (lenStr.charAt(j) - '0');
            }
            if (len < minLen) {
                minLen = len;
                minWord = wordData[i][0];
            }
            if (len > maxLen) {
                maxLen = len;
                maxWord = wordData[i][0];
            }
        }
        return new String[]{minWord, maxWord};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = manualSplit(input);
        String[][] wordData = getWordLengthArray(words);
        String[] result = getShortestAndLongest(wordData);
        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}

