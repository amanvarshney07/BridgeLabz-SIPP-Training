package String_Handling;

import java.util.Scanner;

public class LongestWordInSentence {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a sentence:");
     String text = sc.nextLine();

     int len = getLength(text);
     String word = "", longest = "";
     for (int i = 0; i <= len; i++) {
         char ch = (i == len) ? ' ' : text.charAt(i);
         if (ch == ' ') {
             if (getLength(word) > getLength(longest)) {
                 longest = word;
             }
             word = "";
         } else {
             word += ch;
         }
     }

     System.out.println("Longest word: " + longest);
 }

 public static int getLength(String s) {
     int count = 0;
     while (true) {
         if (count >= s.length()) break;
         s.charAt(count); 
         count++;
     }
     return count;
 }
}

