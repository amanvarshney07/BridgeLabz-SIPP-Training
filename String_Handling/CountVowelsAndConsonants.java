package String_Handling;

import java.util.Scanner;

public class CountVowelsAndConsonants {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String text = sc.nextLine();

     int len = 0;
     while (len < text.length()) len++;

     int vowels = 0, consonants = 0;

     for (int i = 0; i < len; i++) {
         char ch = text.charAt(i);
         if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
             char lower = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
             if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                 vowels++;
             } else {
                 consonants++;
             }
         }
     }

     System.out.println("Vowels: " + vowels);
     System.out.println("Consonants: " + consonants);
 }
}

