package String_Handling;

import java.util.Scanner;

public class SubstringOccurrences {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter main string:");
     String mainStr = sc.nextLine();
     System.out.println("Enter substring to search:");
     String subStr = sc.nextLine();

     int mainLen = getLength(mainStr);
     int subLen = getLength(subStr);
     int count = 0;

     for (int i = 0; i <= mainLen - subLen; i++) {
         boolean match = true;
         for (int j = 0; j < subLen; j++) {
             if (mainStr.charAt(i + j) != subStr.charAt(j)) {
                 match = false;
                 break;
             }
         }
         if (match) count++;
     }

     System.out.println("Occurrences of substring: " + count);
 }

 public static int getLength(String s) {
     int i = 0;
     while (i < s.length()) i++;
     return i;
 }
}

