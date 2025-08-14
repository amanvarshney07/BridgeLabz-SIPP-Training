package Java_Control_Flow_Concepts;

import java.util.Scanner;

public class Rocket_Countdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the countdown start value: ");
        int counter = scanner.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Liftoff!");
        scanner.close();
    }
}

