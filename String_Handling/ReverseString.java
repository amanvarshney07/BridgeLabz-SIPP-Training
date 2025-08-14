package String_Handling;

import java.util.Scanner;

public class ReverseString {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String text = sc.nextLine();

     int len = 0;
     while (len < text.length()) len++;

     System.out.print("Reversed string: ");
     for (int i = len - 1; i >= 0; i--) {
         System.out.print(text.charAt(i));
     }
     System.out.println();
 }
}

