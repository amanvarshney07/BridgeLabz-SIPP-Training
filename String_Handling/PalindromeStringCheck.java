package String_Handling;

import java.util.Scanner;

public class PalindromeStringCheck {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter a string:");
     String text = sc.nextLine();

     int len = 0;
     while (len < text.length()) len++;

     boolean isPalindrome = true;
     for (int i = 0; i < len / 2; i++) {
         if (text.charAt(i) != text.charAt(len - 1 - i)) {
             isPalindrome = false;
             break;
         }
     }

     if (isPalindrome) {
         System.out.println("The string is a palindrome.");
     } else {
         System.out.println("The string is not a palindrome.");
     }
 }
}

