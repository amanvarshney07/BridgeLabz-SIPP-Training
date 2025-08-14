package String_Handling;

import java.util.Scanner;

public class RemoveSpecificCharacter {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the string:");
     String str = sc.nextLine();

     System.out.println("Enter the character to remove:");
     char removeChar = sc.next().charAt(0);

     int len = 0;
     while (len < str.length()) len++;

     System.out.print("Modified String: ");
     for (int i = 0; i < len; i++) {
         char ch = str.charAt(i);
         if (ch != removeChar) {
             System.out.print(ch);
         }
     }
     System.out.println();
 }
}

