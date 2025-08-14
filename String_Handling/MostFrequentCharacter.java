package String_Handling;

import java.util.Scanner;

public class MostFrequentCharacter {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String str = sc.nextLine();

     int len = 0;
     while (len < str.length()) len++;

     int[] freq = new int[256];
     for (int i = 0; i < len; i++) {
         char ch = str.charAt(i);
         freq[ch]++;
     }

     int maxFreq = 0;
     char mostFrequent = ' ';
     for (int i = 0; i < 256; i++) {
         if (freq[i] > maxFreq) {
             maxFreq = freq[i];
             mostFrequent = (char)i;
         }
     }

     System.out.println("Most Frequent Character: '" + mostFrequent + "'");
 }
}

