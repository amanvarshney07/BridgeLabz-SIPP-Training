package String_Handling;

import java.util.Scanner;

public class CompareStringsLexicographically {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter first string:");
     String str1 = sc.nextLine();
     System.out.println("Enter second string:");
     String str2 = sc.nextLine();

     int len1 = getLength(str1);
     int len2 = getLength(str2);

     int min = (len1 < len2) ? len1 : len2;
     int result = 0;

     for (int i = 0; i < min; i++) {
         char c1 = str1.charAt(i);
         char c2 = str2.charAt(i);
         if (c1 != c2) {
             result = (c1 < c2) ? -1 : 1;
             break;
         }
     }

     if (result == 0 && len1 != len2) {
         result = (len1 < len2) ? -1 : 1;
     }

     if (result < 0) {
         System.out.println("\"" + str1 + "\" comes before \"" + str2 + "\"");
     } else if (result > 0) {
         System.out.println("\"" + str2 + "\" comes before \"" + str1 + "\"");
     } else {
         System.out.println("Both strings are equal.");
     }
 }

 public static int getLength(String s) {
     int i = 0;
     while (i < s.length()) i++;
     return i;
 }
}

