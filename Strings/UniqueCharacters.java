package Strings;

import java.util.Scanner;

public class UniqueCharacters {

    public static int getLength(String str) {
        int count = 0;
        while (true) {
            boolean end = false;
            for (char ch = 32; ch <= 126; ch++) {
                if (count >= 1000) break;
                if (str.charAt(count) == ch) {
                    end = true;
                    break;
                }
            }
            if (!end) break;
            count++;
        }
        return count;
    }

    public static char[] getUniqueCharacters(String str) {
        int len = getLength(str);
        char[] unique = new char[len];
        int index = 0;

        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                unique[index++] = current;
            }
        }

        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = unique[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char[] result = getUniqueCharacters(input);
        System.out.print("Unique characters: ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

