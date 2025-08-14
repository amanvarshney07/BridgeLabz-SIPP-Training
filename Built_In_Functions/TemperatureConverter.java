package Built_In_Functions;

import java.util.Scanner;

public class TemperatureConverter {

    public static double toCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double toFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        double temp = sc.nextDouble();

        if (choice == 1) {
            System.out.println("Fahrenheit: " + toFahrenheit(temp));
        } else if (choice == 2) {
            System.out.println("Celsius: " + toCelsius(temp));
        } else {
            System.out.println("Invalid choice.");
        }
    }
}

