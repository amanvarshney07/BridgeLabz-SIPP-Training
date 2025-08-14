package String_Handling;
import java.util.Scanner;

public class ReplaceWord {

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the sentence:");
     String sentence = sc.nextLine();

     System.out.println("Enter the word to replace:");
     String target = sc.nextLine();

     System.out.println("Enter the new word:");
     String replacement = sc.nextLine();

     int sLen = sentence.length();
     int tLen = target.length();

     String result = "";
     int i = 0;

     while (i <= sLen - tLen) {
         boolean match = true;
         for (int j = 0; j < tLen; j++) {
             if (sentence.charAt(i + j) != target.charAt(j)) {
                 match = false;
                 break;
             }
         }

         if (match && (i + tLen == sLen || sentence.charAt(i + tLen) == ' ')) {
             result += replacement;
             i += tLen;
         } else {
             result += sentence.charAt(i);
             i++;
         }
     }

     while (i < sLen) {
         result += sentence.charAt(i);
         i++;
     }

     System.out.println("Modified sentence: " + result);
 }
}

