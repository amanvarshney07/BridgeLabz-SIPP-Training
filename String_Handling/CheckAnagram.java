package String_Handling;

import java.util.Scanner;

public class CheckAnagram {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter first string:");
     String str1 = sc.nextLine();
     System.out.println("Enter second string:");
     String str2 = sc.nextLine();

     int[] freq1 = new int[256];
     int[] freq2 = new int[256];

     int len1 = 0, len2 = 0;
     while (len1 < str1.length()) {
         freq1[str1.charAt(len1)]++;
         len1++;
     }
     while (len2 < str2.length()) {
         freq2[str2.charAt(len2)]++;
         len2++;
     }

     boolean isAnagram = true;
     for (int i = 0; i < 256; i++) {
         if (freq1[i] != freq2[i]) {
             isAnagram = false;
             break;
         }
     }

     if (isAnagram) {
         System.out.println("The strings are anagrams.");
     } else {
         System.out.println("The strings are not anagrams.");
     }
 }
}

