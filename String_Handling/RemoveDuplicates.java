package String_Handling;

import java.util.Scanner;

public class RemoveDuplicates {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String text = sc.nextLine();

     int len = 0;
     while (true) {
         if (isValid(text, len)) len++;
         else break;
     }

     String result = "";
     for (int i = 0; i < len; i++) {
         char current = text.charAt(i);
         boolean duplicate = false;
         for (int j = 0; j < i; j++) {
             if (text.charAt(j) == current) {
                 duplicate = true;
                 break;
             }
         }
         if (!duplicate) result += current;
     }

     System.out.println("Modified String (duplicates removed): " + result);
 }

 public static boolean isValid(String str, int index) {
     return index >= 0 && index < str.length();
 }
}

