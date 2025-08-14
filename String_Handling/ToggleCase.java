package String_Handling;

import java.util.Scanner;

public class ToggleCase {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String text = sc.nextLine();

     int len = 0;
     while (len < text.length()) len++;

     System.out.print("Toggled string: ");
     for (int i = 0; i < len; i++) {
         char ch = text.charAt(i);
         if (ch >= 'a' && ch <= 'z') {
             System.out.print((char)(ch - 32));
         } else if (ch >= 'A' && ch <= 'Z') {
             System.out.print((char)(ch + 32));
         } else {
             System.out.print(ch);
         }
     }
     System.out.println();
 }
}

