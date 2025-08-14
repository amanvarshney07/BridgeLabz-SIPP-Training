package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int count = 0;
        int temp = number;

        
        if (temp == 0) {
            count = 1;
        } else {
           
            while (temp != 0) {
                temp /= 10;   
                count++;      
            }
        }

        System.out.println("The number of digits in " + number + " is: " + count);

        scanner.close();
    }
}

