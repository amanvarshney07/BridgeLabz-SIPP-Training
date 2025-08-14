package Arrays;

import java.util.Scanner;

public class frequency_count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int[] frequency = new int[10];
        while (num != 0) {
            int digit = num % 10;
            frequency[digit]++;
            num /= 10;
        }

        System.out.println("Digit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " = " + frequency[i]);
            }
        }

        sc.close();
    }
}

